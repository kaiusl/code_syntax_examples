import java.util.ArrayList;
import java.util.List;
import java.io.*;

// comment
/* comment */

@interface SomeCustomAnnotation {
}

@SomeCustomAnnotation
enum ColorEnum {
	RED,
	BLUE,
	GREEN
}

interface Interface {
	/**
	 * text text <code>num() - 1</code>
	 * {@link java.util.ArrayList} class)
	 * {@code java.util.ArrayList}
	 *
	 * @param param text text
	 * @return the number.
	 * @deprecated
	 * @exception Exception
	 *                      may return exception
	 * @see SomeBaseClass#display()
	 * @see Interface#interface_method()
	 * @see java.util.ArrayDeque
	 */
	abstract int interface_method();
}

class SomeBaseClass {
	public SomeBaseClass() {
	}

	public void display() {
		System.out.println(b());
		System.out.println(this.b());
		System.out.println(SomeBaseClass.b());
	}

	private static final int b() {
		return 5;
	}
}

final class SomeClass<E> extends SomeBaseClass implements Interface {
	public class InnerClass {
		public int y = 5;
	}

	public static int static_field;
	public E instance_field;
	private ArrayList<E> list;

	public SomeClass() {
		super();
		list = new ArrayList<E>(10);
	}

	@Override
	public int interface_method() {
		return 0;
	}

	public static void static_method() {
	}

	public List<E> return_interface() {
		return list;
	}

	public boolean add(E obj) {
		return list.add(obj);
	}
}

class Main {
	public static <T extends Number & Comparable<T>> void main(
			String[] args,
			List<T> list,
			List<? extends Number> other_list) {
		final int final_var = 1;
		int local_var = final_var;
		var use_parameter = other_list.get(1);

		int ints = 1 + 0x1234 - 0b1000 * local_var;
		long long_ = 1l;
		double doubles = 1 * 1.1 / 1.1e1 % 1.1e-1 + Math.abs(-1) + 1f;
		doubles = (double) ints + doubles;
		boolean bool = true && false || !true && 1 == 2 && 1 != 2 && 1 < 2 && 1 > 2 && 1 <= 2 && 1 >= 2;
		char[] chars = { 'a', '\n' };
		String[] strings = { "abc", "abc\n", new String("abc") };
		var string_ = strings[0];
		System.out.printf("%s.4", string_);

		var base_class = new SomeBaseClass();
		base_class.display();
		var class_ = new SomeClass<String>();
		class_.display();
		class_.add("null");
		class_.interface_method();
		class_.static_method();
		SomeClass.static_method();
		List<String> strs = class_.return_interface();
		var _drop = class_.instance_field;
		var _drop2 = class_.static_field;
		_drop2 = SomeClass.static_field;

		// Control flow
		if (1 < 2) {
		} else if (1 > 2) {
		} else {
		}

		var ternary = 1 < 2 ? 1 : 2;

		switch (1) {
			case 1:
				break;
			case 2:
			case 3:
				break;
			default:
				break;
		}

		try {
		} catch (Exception e) {
		} finally {}

		// Loops
		var i = 0;
		while (i < 5) {
			for (String string : strings) {
				if (string.isEmpty()) {
					break;
				}
			}
			for (int j = 0; i <= 5; i++) {
			}
			i++;
			continue;
		}
		do {
			i++;
		} while (i < 5);

		var arr2 = new ArrayList<Integer>();
		arr2.add(1);
		arr2.forEach((x) -> {
			var some_var = x * x;
		});


	}

	private void private_func() {
	}

	protected double protected_func() {
		return 5;
	}

}