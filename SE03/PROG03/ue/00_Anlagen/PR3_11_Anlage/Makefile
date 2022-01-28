# Makefile
OBJ= Pos.o CPos.o Grobject.o Rect.o Line.o Text.o TRect.o main.o
EXE= grafik
GCC_FLAGS= -std=c++11 -pedantic-errors -Wall

$(EXE): $(OBJ)
	g++ $(GCC_FLAGS) -o $@ $(OBJ)

%.o: %.cpp %.h  # Passt nicht fuer main.o, weil es kein main.h gibt, deshalb separate Regel für main.o unten
	g++ $(GCC_FLAGS) -c $< 

%.h:
	touch $@  # Keine Aenderung am Inhalt der .h-Datei, aber Aktualisieren
		  # ihres Aenderungsdatums, damit die von ihr abhaengige Dateien
		  # neu gebaut werden

# Auch .h-Dateien brauchen make-Regeln, wenn sie andere .h-Dateien inkludieren,
# denn nur so werden auch solche .c-Dateien neu kompiliert, die nur indirekt
# von einer .h-Datei abhaengen:
CPos.h: Pos.h Color.h
Grobject.h: CPos.h
Text.h: Grobject.h
Rect.h: Grobject.h
Line.h: Grobject.h
TRect.h: Text.h Rect.h

main.o: main.cpp TRect.h
	g++ $(GCC_FLAGS) -c $<

.PHONY:
clean:
	rm -f $(EXE) $(OBJ)
