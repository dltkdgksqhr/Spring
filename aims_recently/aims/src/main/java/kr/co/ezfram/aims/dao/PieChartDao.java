package kr.co.ezfram.aims.dao;

import java.util.ArrayList;
import java.util.List;

public class PieChartDao {
	// 차트를 표시하는데 필요한 데이터를 검색합니다. , 실제 데이터는 데이터베이스 또는 기타 영구 저장소에서 가져와야합니다.
	private static final List<KeyValue> pieDataList;
	static {
		pieDataList = new ArrayList<KeyValue>();
		pieDataList.add(new KeyValue("Russia", "17098242"));
		pieDataList.add(new KeyValue("Canada", "9984670"));
		pieDataList.add(new KeyValue("USA", "9826675"));
		pieDataList.add(new KeyValue("China", "9596961"));
		pieDataList.add(new KeyValue("Brazil", "8514877"));
		pieDataList.add(new KeyValue("Australia", "7741220"));
		pieDataList.add(new KeyValue("India", "3287263"));
	}
	public static List<KeyValue> getPieDataList() {
		return pieDataList;
	}
	public static class KeyValue {
		String key;
		String value;
		public KeyValue(String key, String value) {
			this.key = key;
			this.value = value;
		}
		public String getKey() {
			return key;
		}
		public String getValue() {
			return value;
		}
	}

}
