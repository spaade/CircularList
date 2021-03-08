public class CircularList {
    private Auxiliar start = null;
    private Auxiliar end = null;


    public void push(int value) {
        Auxiliar auxiliar = new Auxiliar(value);
        if (start == null) {
            start = auxiliar;
        } else {
            end.netAux = auxiliar;
        }

        end = auxiliar;
        end.netAux = start;
        System.out.println("O valor " + value + " foi adicionado");
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

    public String print() {
        StringBuilder str = new StringBuilder();
        Auxiliar auxiliar = start;
        if (start != null) {
            do {
                str.append("[" + auxiliar.value + ", ");
            } while (auxiliar != start);
            auxiliar = auxiliar.netAux;
            str.append(auxiliar.value).append("]");
        }
        System.out.println(str);
        return str.toString();
    }

    public boolean contains(int searchValue) {
        Auxiliar currentAux = start;
        if (start != null) {
            do {
                if (currentAux.value == searchValue) {
                    System.out.println("O valor " + searchValue + " está contido na lista!");
                    return true;
                }
                currentAux = currentAux.netAux;
            } while (currentAux != start);
        }
        System.out.println("O valor " + searchValue + " não está contido na lista!");
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
