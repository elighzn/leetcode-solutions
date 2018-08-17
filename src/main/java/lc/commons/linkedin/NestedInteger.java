package lc.commons.linkedin;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {

	private Integer value;
	private List<NestedInteger> list;

	public NestedInteger() {
		list = new ArrayList<>();
	}

	public NestedInteger(int value) {
		this.value = value;
	}

	public boolean isInteger() {
		return value == null;
	}

	public Integer getInteger() {
		return value;
	}

	public void setInteger(int value) {
		this.value = value;
		list = null;
	}

	public void add(NestedInteger ni) {
		if (list == null) {
			value = null;
			list = new ArrayList<>();
		}
		list.add(ni);
	}

	public List<NestedInteger> getList() {
		return this.list;
	}
}
