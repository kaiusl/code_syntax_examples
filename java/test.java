import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

interface SomeInterface {
	/**
	 * text text <code>num() - 1</code>
	 * {@link java.util.ArrayList} class)
	 * {@code java.util.ArrayList}
	 *
	 * @param param int text
	 * @return the number.
	 * @deprecated
	 * @exception Exception
	 *                      may return exception
	 * @see SomeBaseClass#display
	 * @see SomeInterface#interface_method
	 * @see java.util.ArrayDeque
	 */
	ColorEnum interface_method(int param) throws Exception;
}

class SomeBaseClass {
	public SomeBaseClass() {
	}

	public void display() {
		System.out.println(b());
		System.out.println(this.b());
		System.out.println(SomeBaseClass.b());
	}

	private static int b() {
		return 5;
	}
}

final class SomeClass<E> extends SomeBaseClass implements SomeInterface {
	public static class InnerClass {
		public int y = 5;
	}

	public static int static_field;
	public E instance_field;
	final private ArrayList<E> list;

	public SomeClass() {
		super();
		list = new ArrayList<E>(10);
	}

	@Override
	public ColorEnum interface_method(int param) throws Exception {
		return switch (param) {
			case 1 -> ColorEnum.RED;
			case 2 -> ColorEnum.GREEN;
			default -> throw new Exception("a");
		};
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
	public static void main(String[] args) {
	}

	public static <T extends Number & Comparable<T>> void test_func(
			String[] args,
			List<T> list,
			List<? extends Number> other_list) throws Exception {
		final int final_var = 1;
		int local_var = final_var + 1;
		var use_parameter = other_list.get(1);

		int ints = 1 + 0x1234 - 0b1000 * local_var;
		long long_ = 1L;
		double doubles = 1 * 1.1 / 1.1e1 % 1.1e-1 + Math.abs(-1) + 1f;
		doubles = (double) ints + doubles;
		boolean bool = true && false || !true && 1 == 2 && 1 != 2 && 1 < 2 && 1 > 2 && 1 <= 2 && 1 >= 2;
		char[] chars = { 'a', '\n' };
		String[] strings = { "abc", "abc\n", new String("abc") };
		var string_ = strings[0];
		System.out.printf("%d %s, %s.4 %s %s %s %s", final_var, local_var, use_parameter, long_, doubles, bool, Arrays.toString(chars));

		System.out.printf("%s.4", string_);

		var base_class = new SomeBaseClass();
		base_class.display();
		var class_ = new SomeClass<String>();
		var inner_class = new SomeClass.InnerClass();
		class_.display();
		class_.add("null");
		var some_enum = class_.interface_method(5);
		class_.static_method();
		SomeClass.static_method();
		List<String> strs = class_.return_interface();
		var str = class_.instance_field;
		var some_int = class_.static_field + inner_class.y + SomeClass.static_field;
		System.out.printf("%s", some_enum);

		// Control flow
		if (some_int < str.length()) {
			some_int++;
		} else if (1 > some_int) {
			some_int++;
		} else {
			some_int += 1;
		}

		int ternary = some_int < 2 ? 1 : some_int;

		switch (ternary) {
			case 1:
				some_int++;
				break;
			case 2:
			case 3:
				some_int += 2;
				break;
			default:
				break;
		}

		switch (ternary) {
			case 1 -> some_int++;
			case 2, 3 -> some_int += 2;
			default -> {
			}
		}

		try {
			some_int++;
		} catch (Exception e) {
			some_int++;
		} finally {
			some_int++;
		}

		// Loops
		var i = some_int;
		while (i < 5) {
			for (String string : strings) {
				if (string.isEmpty()) {
					break;
				}
			}
			for (int j = 0; i <= 5; i++) {
				System.out.print(j);
			}
			if (i % 2 == 0) {
				continue;
			}
			i++;
		}
		do {
			i++;
		} while (i < 5);

		var arr2 = new ArrayList<Integer>();
		arr2.add(1);
		arr2.forEach((x) -> {
			System.out.print(x * x);
		});
	}

	private void private_func() {
	}

	protected double protected_func() {
		private_func();
		return 5;
	}

	public void func() {
		System.out.print(protected_func());
	}

}