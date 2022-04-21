package kr.co.ezfram.aims.elastic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.ezfram.aims.dao.PieChartDao;
import kr.co.ezfram.aims.dao.PieChartDao.KeyValue;

@Service
public class PieChartService { //비즈니스 처리하기 위해 Spring Service 클래스를 생성합니다.
	public List<KeyValue> getPieChartData() {
		return PieChartDao.getPieDataList();
	}
}
