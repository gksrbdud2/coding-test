package etc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > 2022 KAKAO BLIND RECRUITMENT > �Ű� ��� �ޱ�
 * 
 * @author gksrbdud
 *
 */
public class Practice12 {

	public static void main(String[] args) {
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		System.out.println(solution(id_list, report, 2));

	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		// 1. report �ߺ� ����
		Set<String> reportSet = new HashSet<>();
		for (int i = 0; i < report.length; i++) {
			reportSet.add(report[i]);
		}

		// 2. �Ű���� id�� �Ű� ȸ�� map�� ����
		Map<String, Integer> reportedMap = new HashMap<>();
		for (String map : reportSet) {
			String reportedId = map.split(" ")[1];
			reportedMap.put(reportedId, reportedMap.get(reportedId) == null ? 1 : reportedMap.get(reportedId) + 1);
		}

		// 3. �Ű���� Ƚ���� k�̻��� ��� stopIdMap key�� �Ű��� id, value�� cnt+1 �־���
		Map<String, Integer> stopIdMap = new HashMap<>();
		for (String map : reportSet) {
			String reportedId = map.split(" ")[1];
			if (reportedMap.get(reportedId) != null && reportedMap.get(reportedId) >= k) {
				String reportId = map.split(" ")[0];
				stopIdMap.put(reportId, stopIdMap.get(reportId) == null ? 1 : stopIdMap.get(reportId) + 1);
			}
		}

		// 4. id_list ���鼭 stopIdMap�� ���� ������ �־��ְ� ������ 0
		int[] answer = new int[id_list.length];

		for (int i = 0; i < id_list.length; i++) {
			if (stopIdMap.get(id_list[i]) != null) {
				answer[i] = stopIdMap.get(id_list[i]);
			} else {
				answer[i] = 0;
			}
		}

		return answer;
	}

}
