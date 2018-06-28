package API;

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
        name = "City API",
        description = "This is CityAPI",
        urlPatterns = {"/getCityList"}
)
public class CityApi extends HttpServlet {

    private UtilsDAO utilsDAO = new UtilsDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=ISO-8859-1");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("ISO-8859-1");
        PrintWriter out = resp.getWriter();

        List<String> citiesTitleList = new ArrayList<>();

        List<City> cityList = utilsDAO.getCityList();

        for (City aCityList : cityList) {
            citiesTitleList.add("\"" + aCityList.getCityTitle() + "\"");
        }

        System.out.println(citiesTitleList);

        out.print(citiesTitleList);

    }
}
