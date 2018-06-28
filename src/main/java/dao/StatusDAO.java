package dao;

import entity.Claim;

import java.io.IOException;

public interface StatusDAO {

    void claimSetStatusRecall(Claim claim) throws IOException;

    void claimSetStatusConsult(Claim claim) throws IOException;

    void claimSetStatusArchSuccess(Claim claim) throws IOException;

    void claimSetStatusArchFail(Claim claim) throws IOException;

    void claimSetStatusTrash(Claim claim) throws IOException;

    void claimSetStatusDouble(Claim claim) throws IOException;

    void claimSetStatusNew(Claim claim) throws IOException;

}
