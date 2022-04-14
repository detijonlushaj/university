#!/usr/bin/env pybricks-micropython

from pybricks.hubs import EV3Brick
from pybricks.ev3devices import (Motor, TouchSensor, ColorSensor,
                                 InfraredSensor, UltrasonicSensor, GyroSensor)
from pybricks.parameters import Port, Stop, Direction, Button, Color
from pybricks.tools import wait, StopWatch, DataLog
from pybricks.robotics import DriveBase
from pybricks.media.ev3dev import SoundFile, ImageFile

#
##
###
# Startprojekt Team DH1
###
##
#

ev3 = EV3Brick()

# Robot 1-2
left_motor = Motor(Port.B)
right_motor = Motor(Port.C)

fork_motor = Motor(Port.A)

us_sensor = UltrasonicSensor(Port.S4)

driving_robot = DriveBase(left_motor, right_motor,
                          wheel_diameter=55.2, axle_track=106)

gyro = GyroSensor(Port.S1)

color_sensor = ColorSensor(Port.S3)

# ---------------------
##
# Fleißige Hilfsfunktionen
##
# ---------------------


def drive_straight_or_till_distance(straight_dist: int, obstacle_dist: int,
                                    speed=100):
    """
    Fahre gerade aus für `straight_dist` mm oder bis `obstacle_dist` zu 
    einem Objekt erreicht ist
    """
    driving_robot.reset()
    driving_robot.drive(speed, 0)
    while(median_distance_with_wait() > obstacle_dist 
            and driving_robot.distance() <= straight_dist):
        pass
    driving_robot.stop(Stop.BRAKE)
    return driving_robot.distance()


def radar_sweep(deg=8):
    """ Dreht den Roboter `deg`° nach links und rechts und misst 
    dabei die Entfernung

    Gibt eine List mit Tupeln der Form (distanz, grad) aus
    """
    # Negativ: nach links; -1 für den ersten Schleifendurchlauf:
    start_turn_deg = (deg * (-1)) - 1
    driving_robot.turn(start_turn_deg)
    measurements = []
    for i in range((2*deg) + 1):
        driving_robot.turn(1)
        measurements.append((median_distance_with_wait(), i - deg))
    driving_robot.turn(-deg)
    return measurements


def median_distance_with_wait(timeout=1) -> int:
    """ Fragt den US-Sensor zehnmal ab und liefert den Median. 
    Zwischen den Abfragen wird `timeout`ms gewartet.

    Test mit pybricks stub generiert immer Null:
    >>> median_distance_with_wait()
    0
    """
    measurements = []
    for _i in range(0, 10):
        measurements.append(us_sensor.distance())
        wait(timeout)
    measurements.sort()
    return measurements[4]


def turn_with_gyroscope(deg: int, drive_speed=0, turn_rate=20):
    """ Drehen um `deg` Grad, mit Geschwindigkeit `drive_speed` 
    und `turn_rate`.

    Negative `deg` für CCW. `drive_speed` = 0 -> auf der Stelle drehen.
    """
    # TODO sanft beschleunigen? evtl. bessere Gyro Werte?
    cur_angle = gyro.angle()
    target_angle = cur_angle + deg
    wait(5)
    if deg < 0:
        driving_robot.drive(drive_speed, (turn_rate * (-1)))
        while gyro.angle() > target_angle:
            pass
    else:
        driving_robot.drive(drive_speed, turn_rate)
        while gyro.angle() < target_angle:
            pass

    driving_robot.stop(Stop.BRAKE)


def drive_till(drive_speed: int, test_fn: callable):
    """ Geradeaus fahren mit `drive_speed` bis `test_fn` `False` zurückgibt.
    Sanft auf `drive_speed` beschleunigen.
    """
    cur_speed = 0
    increment = drive_speed/10
    while cur_speed < drive_speed and test_fn():
        cur_speed += increment
        driving_robot.drive(cur_speed * (-1), 0)
        wait(100)

    while test_fn():
        driving_robot.drive((drive_speed * (-1)), 0)  # angle)
    driving_robot.stop()


def reset_driving_robot():
    """ DriveBase Instanz aauf vorher definierte Standardwerte zurücksetzten.
    """
    driving_robot.stop()
    driving_robot.reset()
    driving_robot.settings(default_straight_speed, 
                           default_straight_acceleration,
                           default_turn_rate, default_turn_acceleration)

# ---------------------
##
# TROG: Technische Rundfahrt ohne Grund
# Funktionen sind Fahranweisungen für Roboter zu Testzwecken
##
# ---------------------


def test_drive_calibration_check():
    """ TEST der Kalibrierung

    Sollte am Ende genau so stehen wie am Anfang, Macht witzige Geräusche ^^
    """
    ev3.speaker.beep()
    driving_robot.straight(1000)
    ev3.speaker.play_file(SoundFile.BOING)
    driving_robot.turn(180)
    ev3.speaker.play_file(SoundFile.BOING)
    driving_robot.straight(1000)
    ev3.speaker.beep()
    driving_robot.turn(180)
    ev3.speaker.play_file(SoundFile.CHEERING)


def test_drive_straight_with_gyro():
    """ TEST: 10s geradeaus fahren, gerade halten mit Gyroskop

    Gut auf Teppichböden :-)
    """
    driving_robot.reset()
    start_us_distance = us_sensor.distance()
    gyro.reset_angle(0)
    wait(5)
    max_speed = 100
    turn_factor = 2
    watch = StopWatch()
    while watch.time() <= (10*1000):
        speed = min((watch.time() / (max_speed / 4)), max_speed)
        angle = 0
        if gyro.angle() > 0:
            angle = -1 * turn_factor
        elif gyro.angle() < 0:
            angle = 1 * turn_factor
        driving_robot.drive(speed * (1), angle)
    driving_robot.stop()
    print("Distances:")
    print(driving_robot.distance())
    print(us_sensor.distance() - start_us_distance)
    print("Angles:")
    print(driving_robot.angle())
    print(gyro.angle())

def test_drive_gyro_drift() -> int:
    """ TEST: Halte die Position und frage das Gyroskop mehrmals ab.

    Test benötigt 10 Sekunden. Gibt die Differenz von Start- und Ist-Wert
    zurück.

    Wenn alles ok:
    >>> test_drive_gyro_drift()
    0
    """
    driving_robot.stop(Stop.BRAKE)
    wait(500)
    start_angle = gyro.angle()
    for _i in range(0, 20):
        wait(500)
        cur_angle = gyro.angle()
        if cur_angle != start_angle:
            ev3.speaker.play_file(SoundFile.ERROR)
            return (start_angle - cur_angle)
    ev3.speaker.play_file(SoundFile.CONFIRM)
    return 0


# ---------------------
##
# Aufgaben
# Funktionen sind Fahranweisungen für Roboter um einzelne 
# Aufgaben zu erledigen
##
# ---------------------


def exercise_m01_additionalPump():
    """ AUFGABE M01 Zusatzpumpe

    Startpunkt: In der Base, an der Westwand, Blickrichtung Westen, 
    ca 20cm nach Norden.
    Werkzeug: Gabel mit Mittelsteg
    """
    #
    # Diese Methode fährt vom Startpunkt zur zusätzlichen Pumpe
    # und drückt Sie an die vorgesehene Position
    #

    # Vorbereitung für die Ausführung und Initialisierung
    #
    fork_motor.run_until_stalled(100)
    driving_robot.reset()
    driving_robot.settings(
        straight_speed=80, straight_acceleration=100, turn_rate=70)
    gyro.reset_angle(0)
    wait(500)

    # Zur Pumpe fahren und an die Wand drücken
    # Vom Startpunkt auf Abstand fahren dann 90 Grad drehen

    max_speed = 70

    distance_to_filter = 390
    drive_till(max_speed, lambda: (
        driving_robot.distance() > (distance_to_filter - 100)
        or median_distance_with_wait() < distance_to_filter))

    wait(500)
    turn_with_gyroscope(90)
    # driving_robot.turn(90)  # 90 Grad drehen und Weg fahren
    wait(500)
    driving_robot.straight(300)
    gyro.reset_angle(0)
    sweep_result = radar_sweep(10)  # Ziel anpeilen und in die Richtung fahren
    sweep_result.sort(key=lambda pair: pair[0])
    print(sweep_result)
    _nearest_dist, nearest_deg = sweep_result[0]
    driving_robot.turn(nearest_deg - 5)
    # fork_motor.run_until_stalled(-90)
    driving_robot.reset()

    # Nach dem Anpeilen, Pumpe an die Wand schieben
    #
    gyro.reset_angle(0)
    while us_sensor.distance() > 200:  # Bis 10 cm vor die Pumpe fahren.
        driving_robot.drive(100, 0)
    driving_robot.stop()
    fork_motor.run_until_stalled(-500)  # Gabel runter zum ranschieben
    wait(1000)
    driving_robot.straight(250)  # Zusatzpumpe an die Wand drücken
    driving_robot.stop()

    # Nach dem Andrücken, Rückwärts fahren und Roboter links drehen, um 
    # Zusatzpumpe an die Pumpe zu drücken
    #
    driving_robot.straight(-120)  # Rüchwärts fahren und Gabel leicht anheben
    wait(500)
    fork_motor.run_time(75, 500)
    wait(1000)
    driving_robot.reset()

    # Robotor in Position  fahren zum Ranschieben, Gabel leicht anheben
    while driving_robot.angle() <= 25:
        driving_robot.drive(20, 25)
    driving_robot.straight(50)
    driving_robot.stop()
    # Zusatzpumpe an die Position drücken und wieder zurückdrehen
    driving_robot.drive(60, -60)
    wait(1350)
    driving_robot.stop()
    driving_robot.drive(-60, 60)
    wait(1350)
    driving_robot.stop()

    # Zum Startpoint zurückfahren
    #
    driving_robot.straight(-100)
    fork_motor.run_until_stalled(200)
    # driving_robot.turn(-200)
    driving_robot.turn(150)
    driving_robot.stop()
    driving_robot.settings(straight_speed=200)
    driving_robot.straight(median_distance_with_wait() - 100)
    # ev3.speaker.play_file(SoundFile.CHEERING)
    ev3.speaker.beep()


def exercise_m02_pumpingSystem():
    """ AUFGABE M02 Pumpsystem.

    Startpunkt: In der Base, an der Westwand, Blickrichtung Norden, 
    parallel zur Westwand!
    Werkzeug: Gabelarme ohne Mittelsteg, Abstandshalter links
    """
    #
    # Diese Methode fährt vom Startpunkt zum Pumpsystem und betätigt den Hebel
    #

    # Vorbereitung und Initialisierung
    #

    ev3.speaker.beep()
    driving_robot.reset()
    # Gabel hochfahren um den Ultraschallsensor freizugeben
    fork_motor.run_until_stalled(300)

    # Zum Punpsystem fahren und Hebel betätigen
    #

    # Bis kurz vor das Pumpsystem fahren
    # TODO hier besser mit DriveBase Werten fahren?
    #   falls US-Sensor unzuverlässig
    driving_robot.straight(median_distance_with_wait() - 500)
    driving_robot.stop()
    fork_motor.run_until_stalled(-300)

    # TODO mit DriveBase Wertem gegenprüfen?
    # An das Pumpsystem ranfahren, mit unterschiedlichen Motorstärken 
    # um den Roboter an die Wand zu drücken
    while median_distance_with_wait() > 115:  # 105/ 4/8
        left_motor.run(200)
        right_motor.run(205)
    driving_robot.stop()
    fork_motor.run_until_stalled(1000)  # Hebel betätigen
    ev3.speaker.beep()

    # Zum Startpoint zurückfahren
    #
    driving_robot.straight(driving_robot.distance() * (-1))
    ev3.speaker.beep()


# let it rain
# 380mm -> West
# turn facing south
# 800 north
# ~115° CCW
# sweep
# drive slowly towards farthermost distance
# measure color: first white then black -> stop
# fork until stalled
# turn left
# --
#
def exercise_m04_rain():
    """ AUFGABE M04 Regen

    Startpunkt: In der Base, Blickrichtung Westen, parallel zur Südwand, 
    ca 20cm nach Norden. Werkzeug: Gabel mit Mittelsteg, Farbsensor
    """
    driving_robot.reset()
    driving_robot.settings(
        straight_speed=50, straight_acceleration=100, turn_rate=45)
    gyro.reset_angle(0)
    wait(500)
    max_speed = 90

    distance_westbound = 370  # 380 ist etwas zu viel
    drive_till(max_speed, lambda: (
        driving_robot.distance() > (distance_westbound - 100)
        or median_distance_with_wait() < distance_westbound))
    wait(500)
    driving_robot.turn(-90)
    wait(500)

    distance_northbound = 800
    drive_till(max_speed, lambda: (
        driving_robot.distance() > (distance_northbound - 100) 
        or median_distance_with_wait() < distance_northbound))

    driving_robot.turn(-115)
    wait(500)
    gyro.reset_angle(0)
    sweep_result = radar_sweep(10)
    sweep_result.sort(key=lambda pair: pair[0])
    print(sweep_result)
    _nearest_dist, nearest_deg = sweep_result[0]

    driving_robot.turn(nearest_deg - 3)

    fork_motor.run_until_stalled(-200)
    driving_robot.straight(150)
    drive_till(-50, lambda: color_sensor.reflection() < 90)
    driving_robot.straight(30)

    wait(500)
    fork_motor.run_until_stalled(200)

    driving_robot.turn(10)
    ev3.speaker.beep()

    fork_motor.run_until_stalled(-200)
    driving_robot.straight(-250)
    fork_motor.run_until_stalled(200)
    driving_robot.turn(130)

    gyro.reset_angle(0)
    sweep_result = radar_sweep(20)
    sweep_result.sort(key=lambda pair: pair[0], reverse=True)
    print(sweep_result)
    furthest_dist, furthest_deg = sweep_result[0]
    driving_robot.turn(furthest_deg - 5)
    driving_robot.stop()
    driving_robot.settings(straight_speed=200)
    driving_robot.straight(furthest_dist - 100)
    ev3.speaker.beep()


def exercise_m05_filter():
    """ AUFGABE M05 Filter.

    Startpunkt: Roboter steht gerade an der Westwand in der Base, 
    Blickrichtung Westen, ca 20cm nach Norden.
    Werkzeug: Auslegerarm am linken Gabelarm, ohne Farbsensor
    """
    #
    # Die Methode betätigt den Filter
    #

    # Vorbereitung und Initialisierung
    #
    driving_robot.reset()
    driving_robot.settings(
        straight_speed=50, straight_acceleration=100, turn_rate=70)
    wait(500)
    gyro.reset_angle(0)

    # In Richtung Filter fahren und 90 Grad drehen
    #
    max_speed = 70
    cur_speed = 0
    # Langsames Anfahren damit der Roboter sich nicht verdreht
    while cur_speed < max_speed:
        cur_speed += 10
        driving_robot.drive(cur_speed * (-1), 0)
        wait(100)
    angle = 0
    distance_to_filter = 620
    while (driving_robot.distance() > (distance_to_filter - 100)
            or median_distance_with_wait() < distance_to_filter):
        cur_angle = gyro.angle()
        angle = cur_angle * (-0.7)
        driving_robot.drive((max_speed * (-1)), angle)
    driving_robot.stop()
    wait(500)
    turn_with_gyroscope(90)
    wait(500)

    # Den Hebel anpeilen und rein drücken
    #
    gyro.reset_angle(0)
    sweep_result = radar_sweep(10)
    sweep_result.sort(key=lambda pair: pair[0], reverse=True)
    print(sweep_result)
    furthermost_dist, furthermost_deg = sweep_result[0]
    driving_robot.turn(furthermost_deg - 1)
    fork_motor.run_until_stalled(-90)
    driving_robot.reset()
    drive_straight_or_till_distance(furthermost_dist - 90, 90)
    driving_robot.straight(-150)
    fork_motor.run_until_stalled(90)

    # Zum Startpunkt zurückfahren
    #
    driving_robot.turn((gyro.angle() * (-1)) - 90)
    driving_robot.stop()
    driving_robot.settings(straight_speed=200)
    driving_robot.straight(median_distance_with_wait() - 100)
    ev3.speaker.play_file(SoundFile.CHEERING)


# ---------------------
##
# MAIN
# Aufruf der einzelnen Aufgaben
##
# ---------------------
if __name__ == '__main__':
    ev3.speaker.beep()  # Es lebt! Es lebt! [Frankenstein1931]

    # Standardwerte der DriveBase Instanz speichern. Werden zwischen
    # den Aufgaben mit `reset_drive_base()` wiederhergestellt.
    default_straight_speed, default_straight_acceleration, \
    default_turn_rate, default_turn_acceleration \
        = driving_robot.settings()

    # Beginne sobald ein Knopf gedrückt wird.
    while len(ev3.buttons.pressed()) == 0:
        pass
    exercise_m02_pumpingSystem()
    reset_driving_robot()

    while len(ev3.buttons.pressed()) == 0:
        pass
    exercise_m05_filter()
    reset_driving_robot()

    while len(ev3.buttons.pressed()) == 0:
        pass
    exercise_m01_additionalPump()
    reset_driving_robot()

    while len(ev3.buttons.pressed()) == 0:
        pass
    exercise_m04_rain()

    # Alles lief nach Plan, nur der Plan war...
    ev3.speaker.beep()
