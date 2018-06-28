package API;

import API.addressAPI.Warehouse;
import dao.UtilsDAO;
import dao.UtilsDAOImpl;
import entity.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "Warehouse API",
        description = "This is WarehouseAPI",
        urlPatterns = {"/getWarehouseList"}
)
public class WarehouseAPI extends HttpServlet{


    private UtilsDAO utilsDAO = new UtilsDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=ISO-8859-1");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("ISO-8859-1");
        PrintWriter out = resp.getWriter();

        List<String> warehouseTitleList = new ArrayList<>();

        if (req.getParameter("city_title") != null) {
            String cityTitle = req.getParameter("city_title");

            List<Warehouse> warehouseList = utilsDAO.getWarehouseList(cityTitle);

            for (Warehouse aWarehouseList : warehouseList) {
                warehouseTitleList.add("\"" + aWarehouseList.getDescriptionRu().replace("\"", "\'") + "\"");
            }

            System.out.println(warehouseTitleList);
        }


        out.print(warehouseTitleList);

    }
}
