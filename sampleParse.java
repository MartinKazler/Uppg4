package parseinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sampleParse {
	public static String COMMA_DELIMITER = ",";

	public static void main(String[] args) {
		List<Reader> records = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("sample.csv"));) {
			while (scanner.hasNextLine()) {
				List<String> line = getRecordFromLine(scanner.nextLine());
				Reader Reader = new Reader(line);
				records.add(Reader);
			}
        records.sort(null);
		} catch (FileNotFoundException Q) {
			Q.printStackTrace();
		}
		int namnx = 0;
		int namny = 0;
		int jobb = 0;
		
		for (int i = 1; i < records.size(); i++) {
			Reader ReaderX = records.get(i);
			
			if (ReaderX.namn.contains("a")) {
				namnx++;
			}
			if (ReaderX.namnb.contains("a")) {
				namny++;
			}
			if (ReaderX.jobb.contains("android app")) {
				jobb++;
			}

		}
		for (int i = 1; i < records.size(); i++) {
			Reader ReaderY = records.get(i);

			for (int b = 1; b < records.size(); b++) {
				Reader ReaderXY = records.get(b);
               if (ReaderY.Time.equals(ReaderXY.Time) && b != i && !ReaderY.Time.isBlank()) {

					System.out.println("Samma Timestpamps " + ReaderY.Time + " " + ReaderY.namn
							+ " och " + ReaderY.namnb);
				}

			}

		}
		System.out.println("\nTottalt personer med a i namnet " + (namnx + namny) + ".\n");
		System.out.println("Personer med a i sitt namn i grp.1 " + namnx + ".\n");
		System.out.println("Personer med a i sitt namn i grp.2 " + namny + ".\n");
		System.out.println(jobb + " Personer som jobbar med Adroid app");
	}

	private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next().toLowerCase());

			}

		}
		return values;

	}

}