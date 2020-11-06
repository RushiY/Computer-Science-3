package employeeDatabasePartOne;

public class EmployeeDatabaseQuadratic {
	private Entry[] table;

	public EmployeeDatabaseQuadratic(int size) {
		table = new Entry[size];
	}

	public int hashCode(int key) {
		return key % table.length;
	}

	public Employee put(int key, String value) {
		int code = hashCode(key);
		int i = code;
		int counter = 1;

		do {
			if (table[i] == null) {
				table[i] = new Entry(key, new Employee(value));
				return new Employee(value);
			}

			if (table[i].ID == key) {
				table[i].employee = new Employee(value);
				return new Employee(value);
			}

			i = (i + counter * counter++) % table.length;

		} while (i != code);
		return null;
	}

	public Employee get(int key) {
		int code = hashCode(key);
		for (int i = 0; i < table.length; i++) {
			if (table[code] == null)
				break;
			else if (table[code].ID == key)
				return table[code].employee;

			code++;
		}
		return null;
	}

	@Override
	public String toString() {
		String output = "";
		for (Entry entry : table) {
			if (entry != null)
				output += entry.ID + " -> " + entry.employee.toString() + "\n";
		}
		return output;
	}

	private class Entry {
		private int ID;
		private Employee employee;

		public Entry(int ID, Employee employee) {
			this.ID = ID;
			this.employee = employee;
		}
	}

}
