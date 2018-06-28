package dao;

import API.addressAPI.Warehouse;
import entity.City;
import entity.CountClaim;
import entity.HeaderInfo;
import entity.RefusingReason;

import java.util.List;

public interface UtilsDAO {

    CountClaim getCountClaim();

    List<RefusingReason> getRefusingReasonList();

    List<RefusingReason> getRefusingReasonTrashList();

    List<RefusingReason> getRefusingReasonCancelList();

    RefusingReason getRefusingReasonById(Integer refusingReasonId);

    List<City> getCityList();

    Integer getCityId(String cityTitle);

    List<Warehouse> getWarehouseList(String cityTitle);

    Integer getWarehouseId(String warehouseTitle);

    HeaderInfo getHeaderInfo(Integer claimId);

    public java.util.Date getSysDate();


}
