
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		do {
			try {
				// read values from a console
				System.out.println("Enter height");
				str = br.readLine();
				double height = Double.parseDouble(str);
				System.out.println("Enter width");
				str = br.readLine();
				double width = Double.parseDouble(str);
				// initialize rectangle
				Rectangle rectangle = new Rectangle(height, width);

				// validate if the object is properly initialized
				System.out.println(height == rectangle.getHeight());
				System.out.println(width == rectangle.getWidth());
			}

			catch (NumberFormatException e) {
				System.out.println("Podano niedozwolon¹ wartoœæ lub znak ");
			}

			catch (LogicException e) {
				System.out.print(e.getMessage());
			}

			catch (IOException e) {
				System.out.println("B³¹d wejœcia/wyjœcia ");
			}

			System.out.println("Type any string to continue or exit to quit the program");
			str = br.readLine();
		} while (!str.equals("exit"));
		System.out.println("Bye, bye!");

	}

}