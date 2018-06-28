package dao;

import entity.Claim;
import entity.User;
import entity.Workorder;

import java.io.IOException;
import java.util.List;

public interface WorkorderDAO {
    void createWorkorder(Claim claim) throws IOException;

    Workorder getWorkorder(Integer id) throws IOException;

    void setWorkorderCurrentUser(Workorder workorder) throws IOException;

    void setWorkorderStatus(Workorder workorder) throws IOException;

    void setWorkorderPostalInvoiceNumber(Workorder workorder) throws IOException;

//    List<Workorder> getWorkorderListNew() throws IOException;

//    List<Workorder> getWorkorderListWaitingDeparture() throws IOException;

//    List<Workorder> getWorkorderListInRoad() throws IOException;

//    List<Workorder> getWorkorderListArrived() throws IOException;

//    List<Workorder> getClaimListArchFail() throws IOException;

//    List<Workorder> getClaimListTrash() throws IOException;

//    List<Workorder> getClaimListDouble() throws IOException;

//    void updateWorkorder(Workorder workorder) throws IOException;

//    void setUserInClaim(Claim claim, User user) throws IOException;
}


