package entity;

public class User {
    private Integer userId;
    private String login;
    private String password;
    private Integer positionId;
    private String fio;
    private Integer salesPercent;
    private Integer percentTypeId;
    private Integer roleId;
    private Integer statusId;
    private Integer headUserId;
    private Integer salary;

    public User() {
    }

    public User(String login, String password, Integer positionId, String fio, Integer salesPercent, Integer percentTypeId, Integer roleId, Integer statusId, Integer headUserId, Integer salary) {
        this.login = login;
        this.password = password;
        this.positionId = positionId;
        this.fio = fio;
        this.salesPercent = salesPercent;
        this.percentTypeId = percentTypeId;
        this.roleId = roleId;
        this.statusId = statusId;
        this.headUserId = headUserId;
        this.salary = salary;
    }

    public User(Integer userId, String login, String password, Integer positionId, String fio, Integer salesPercent, Integer percentTypeId, Integer roleId, Integer statusId, Integer headUserId, Integer salary) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.positionId = positionId;
        this.fio = fio;
        this.salesPercent = salesPercent;
        this.percentTypeId = percentTypeId;
        this.roleId = roleId;
        this.statusId = statusId;
        this.headUserId = headUserId;
        this.salary = salary;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getSalesPercent() {
        return salesPercent;
    }

    public void setSalesPercent(Integer salesPercent) {
        this.salesPercent = salesPercent;
    }

    public Integer getPercentTypeId() {
        return percentTypeId;
    }

    public void setPercentTypeId(Integer percentTypeId) {
        this.percentTypeId = percentTypeId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getHeadUserId() {
        return headUserId;
    }

    public void setHeadUserId(Integer headUserId) {
        this.headUserId = headUserId;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (positionId != null ? !positionId.equals(user.positionId) : user.positionId != null) return false;
        if (fio != null ? !fio.equals(user.fio) : user.fio != null) return false;
        if (salesPercent != null ? !salesPercent.equals(user.salesPercent) : user.salesPercent != null) return false;
        if (percentTypeId != null ? !percentTypeId.equals(user.percentTypeId) : user.percentTypeId != null)
            return false;
        if (roleId != null ? !roleId.equals(user.roleId) : user.roleId != null) return false;
        if (statusId != null ? !statusId.equals(user.statusId) : user.statusId != null) return false;
        if (headUserId != null ? !headUserId.equals(user.headUserId) : user.headUserId != null) return false;
        return salary != null ? salary.equals(user.salary) : user.salary == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (positionId != null ? positionId.hashCode() : 0);
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (salesPercent != null ? salesPercent.hashCode() : 0);
        result = 31 * result + (percentTypeId != null ? percentTypeId.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (headUserId != null ? headUserId.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", positionId=" + positionId +
                ", fio='" + fio + '\'' +
                ", salesPercent=" + salesPercent +
                ", percentTypeId=" + percentTypeId +
                ", roleId=" + roleId +
                ", statusId=" + statusId +
                ", headUserId=" + headUserId +
                ", salary=" + salary +
                '}';
    }
}
