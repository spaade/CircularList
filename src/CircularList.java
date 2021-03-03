import java.util.logging.Logger;

public class CircularList {
    private Auxiliar start = null;
    private Auxiliar end = null;

    private static final Logger LOGGER = Logger.getLogger( CircularList.class.getName() );

    public void push(int value) {
        Auxiliar auxiliar = new Auxiliar(value);
        if (start == null) {
            start = auxiliar;
        } else {
            end.netAux = auxiliar;
        }

        end = auxiliar;
        end.netAux = start;
    }

    public void remove(int valueToRemove) {
        Auxiliar auxiliar = start;

        if (start != null) {
            if (auxiliar.value == valueToRemove) {
                start = start.netAux;
                end.netAux = start;
            } else {
                do {
                    Auxiliar nextAuxliar = auxiliar.netAux;
                    if (nextAuxliar.value == valueToRemove) {
                        auxiliar.netAux = nextAuxliar.netAux;
                        break;
                    }

                    auxiliar = auxiliar.netAux;
                } while (auxiliar != start);
            }
        }
    }

    public void print() {
        Auxiliar auxiliar = start;

        if (start != null) {
            do {
                LOGGER.info(auxiliar.value + " ");
                auxiliar = auxiliar.netAux;
            } while (auxiliar != start);
        }
    }

    public boolean contains(int searchValue) {
        Auxiliar currentAux = start;
        if (start != null) {
            do {
                if (currentAux.value == searchValue) {
                    System.out.println(true);
                    return true;
                }
                currentAux = currentAux.netAux;
            } while (currentAux != start);
        }
        System.out.println(false);
        return false;
    }

    public Auxiliar getStart() {
        return start;
    }

    public void setStart(Auxiliar start) {
        this.start = start;
    }

    public Auxiliar getEnd() {
        return end;
    }

    public void setEnd(Auxiliar end) {
        this.end = end;
    }
}
