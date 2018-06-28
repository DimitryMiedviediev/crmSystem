package entity;

public class CountClaim {
    private int newClaim;
    private int recallClaim;
    private int consultClaim;
    private int archSuccessClaim;
    private int archFailClaim;
    private int trashClaim;
    private int doubleClaim;

    public CountClaim(CountClaim countClaim) {
    }

//    public CountClaim(int newClaim, int recallClaim, int consultClaim, int archSuccessClaim, int archFailClaim, int trashClaim) {
//        this.newClaim = newClaim;
//        this.recallClaim = recallClaim;
//        this.consultClaim = consultClaim;
//        this.archSuccessClaim = archSuccessClaim;
//        this.archFailClaim = archFailClaim;
//        this.trashClaim = trashClaim;
//    }

    public CountClaim(int newClaim, int recallClaim, int consultClaim, int archSuccessClaim, int archFailClaim, int trashClaim, int systemFailClaim) {
        this.newClaim = newClaim;
        this.recallClaim = recallClaim;
        this.consultClaim = consultClaim;
        this.archSuccessClaim = archSuccessClaim;
        this.archFailClaim = archFailClaim;
        this.trashClaim = trashClaim;
        this.doubleClaim = systemFailClaim;
    }

    public int getNewClaim() {
        return newClaim;
    }

    public void setNewClaim(int newClaim) {
        this.newClaim = newClaim;
    }

    public int getRecallClaim() {
        return recallClaim;
    }

    public void setRecallClaim(int recallClaim) {
        this.recallClaim = recallClaim;
    }

    public int getConsultClaim() {
        return consultClaim;
    }

    public void setConsultClaim(int consultClaim) {
        this.consultClaim = consultClaim;
    }

    public int getArchSuccessClaim() {
        return archSuccessClaim;
    }

    public void setArchSuccessClaim(int archSuccessClaim) {
        this.archSuccessClaim = archSuccessClaim;
    }

    public int getArchFailClaim() {
        return archFailClaim;
    }

    public void setArchFailClaim(int archFailClaim) {
        this.archFailClaim = archFailClaim;
    }

    public int getTrashClaim() {
        return trashClaim;
    }

    public void setTrashClaim(int trashClaim) {
        this.trashClaim = trashClaim;
    }

    public int getDoubleClaim() {
        return doubleClaim;
    }

    public void setDoubleClaim(int doubleClaim) {
        this.doubleClaim = doubleClaim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountClaim that = (CountClaim) o;

        if (newClaim != that.newClaim) return false;
        if (recallClaim != that.recallClaim) return false;
        if (consultClaim != that.consultClaim) return false;
        if (archSuccessClaim != that.archSuccessClaim) return false;
        if (archFailClaim != that.archFailClaim) return false;
        if (trashClaim != that.trashClaim) return false;
        return doubleClaim == that.doubleClaim;
    }

    @Override
    public int hashCode() {
        int result = newClaim;
        result = 31 * result + recallClaim;
        result = 31 * result + consultClaim;
        result = 31 * result + archSuccessClaim;
        result = 31 * result + archFailClaim;
        result = 31 * result + trashClaim;
        result = 31 * result + doubleClaim;
        return result;
    }

    @Override
    public String toString() {
        return "CountClaim{" +
                "newClaim=" + newClaim +
                ", recallClaim=" + recallClaim +
                ", consultClaim=" + consultClaim +
                ", archSuccessClaim=" + archSuccessClaim +
                ", archFailClaim=" + archFailClaim +
                ", trashClaim=" + trashClaim +
                ", doubleClaim=" + doubleClaim +
                '}';
    }
}
