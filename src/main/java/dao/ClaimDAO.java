package dao;

        import entity.Claim;
        import entity.User;

        import java.io.IOException;
        import java.util.List;

public interface ClaimDAO {
    void createClaim(Claim claim) throws IOException;

    Claim getClaim(Integer id) throws IOException;

    List<Claim> getClaimListNew() throws IOException;

    List<Claim> getClaimListRecall() throws IOException;

    List<Claim> getClaimListConsult() throws IOException;

    List<Claim> getClaimListArchSuccess() throws IOException;

    List<Claim> getClaimListArchFail() throws IOException;

    List<Claim> getClaimListTrash() throws IOException;

    List<Claim> getClaimListDouble() throws IOException;

    void updateClaim(Claim claim) throws IOException;

    void setUserInClaim(Claim claim, User user) throws IOException;

    void changeUserInClaim(Claim claim, User user) throws IOException;

    Integer createClaimFromWeb(Claim claim) throws IOException;
}


