package kr.co.ezfram.aims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ezfram.aims.dao.PieChartDao.KeyValue;
import kr.co.ezfram.aims.elastic.service.PieChartService;

// 클라이언트에서 오는 요청/응답을 처리하는 Spring Controller 클래스
@Controller
@RequestMapping("/piecharta")
public class PieChartController {
	@Autowired
	private PieChartService pieChartService;
	@RequestMapping(value = "/piechart", method = RequestMethod.GET)
	public String springMVC(ModelMap modelMap) {
		List<KeyValue> pieDataList = pieChartService.getPieChartData();
		modelMap.addAttribute("pieDataList", pieDataList);
		return "index";
	}

}
