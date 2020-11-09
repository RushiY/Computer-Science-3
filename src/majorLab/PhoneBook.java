package majorLab;

public class PhoneBook implements IMap {
	private Entry[] table;

	public PhoneBook() {
		table = new Entry[5000];
	}

	@Override
	public PhoneNumber put(Person person, PhoneNumber phone) {
		int code = person.hashCode() + phone.hashCode();
		for (int i = 0; i < table.length; i++) {
			if (table[code] == null) {
				table[code] = new Entry(person, phone);
				return phone;
			}
			code++;
			code %= table.length;

		}
		return phone;
	}

	@Override
	public PhoneNumber get(Person person) {
		try {
			int code = person.hashCode();
			for (int i = 0; i < table.length; i++) {
				if (table[code].person.equals(person)) {
					return table[code].number;
				}
				code++;
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int size() {
		return table.length;
	}

	@Override
	public PhoneNumber remove(Person person) {
		try {
			int code = person.hashCode();
			for (int i = 0; i < table.length; i++) {
				if (table[code].person.equals(person)) {
					int temp = person.hashCode();
					Entry obj = table[temp];
					table[temp] = null;
					return obj.number;
				}
				code++;
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null)
				output += table[i].toString() + "\n";
		}
		return output;
	}

	private class Entry {
		private Person person;
		private PhoneNumber number;

		public Entry(Person person, PhoneNumber number) {
			this.person = person;
			this.number = number;
		}

		public String toString() {
			return person.toString() + " -> " + number.toString();
		}
	}
}
