package benworks.java.util.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import benworks.java.util.comparator.Step;
import benworks.java.util.comparator.StepComparator;

public class StepComparatorTest {

	@Test
	public void sort2() throws Exception {
		List<Step> steps = new ArrayList<Step>();
		steps.add(new Step("2012-11-02 11:22:09", "广州市海珠区"));
		steps.add(new Step("2012-10-02 10:22:09", "广州市天河区"));

		System.out.println("---------------排序前------------------");
		for (Step step : steps) {
			System.out.print(step.getAcceptAddress());
			System.out.println(step.getAcceptTime());
		}

		System.out.println("---------------排序后(按时间)------------------");
		// 对集合对象进行排序
		StepComparator comparator = new StepComparator();
		Collections.sort(steps, comparator);
		if (steps != null && steps.size() > 0) {
			for (Step step : steps) {
				System.out.print(step.getAcceptAddress());
				System.out.println(step.getAcceptTime());
			}
		}
	}

	@Test
	public void sortn() throws Exception {
		List<Step> steps = new ArrayList<Step>();
		steps.add(new Step("2012-02-02 11:02:02", "广州市海珠区"));
		steps.add(new Step("2011-10-01 10:21:29", "广州市天河区"));
		steps.add(new Step("2013-01-12 10:20:09", "广州市番禺区"));
		steps.add(new Step("2006-09-16 10:06:08", "广州市花都区"));
		steps.add(new Step("2011-05-21 10:21:12", "广州市越秀区"));

		System.out.println("---------------排序前------------------");
		for (Step step : steps) {
			System.out.print(step.getAcceptAddress());
			System.out.println(step.getAcceptTime());
		}

		System.out.println("---------------排序后(按时间)------------------");
		// 对集合对象进行排序
		StepComparator comparator = new StepComparator();
		Collections.sort(steps, comparator);
		if (steps != null && steps.size() > 0) {
			for (Step step : steps) {
				System.out.print(step.getAcceptAddress());
				System.out.println(step.getAcceptTime());
			}
		}
	}
}