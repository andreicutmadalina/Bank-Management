package Reports;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entity.BankAccount;
import entity.Transactions;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Stream;


public class Report {
    private String name ;
    private List<BankAccount> bankAccounts;

    /**
     * @param name nume pdf
     *             Seteaza valorile variabilelor instanta.
     *             Apeleaza report()
     */
    public  Report(String name, List<BankAccount> bankAccounts)
    {
        this.name = name;
        this.bankAccounts =  bankAccounts;
        report();
    }

    /**
     * Creeaza un pdf.
     * Gaseste inregistrarile din tabel.
     * Creeaza un tabel cu 3 coloane.
     */
    public void report()
    {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(name));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        document.open();
        PdfPTable table = new PdfPTable(4);
        addTableHeader(table);
        addRows(table, bankAccounts);

        try {
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
    }

    /**
     * @param table tabel
     * @param bankAccounts inregistrarile despre conturile unuil client
     *                Adauga linii cu date despre tranzactii in tabel.
     */
    private void addRows(PdfPTable table, List<BankAccount> bankAccounts) {
        for(BankAccount account : bankAccounts)
            for(Transactions c : account.getTransactions())
                {
                    table.addCell("" + account.getIdAccount());
                    table.addCell("" + c.getDate());
                    table.addCell("" + c.getAmount());
                    table.addCell("" + c.getType());
                }
    }

    /**
     * @param table tabel
     *              Creeaza header-ul tabelului.
     */
    private void addTableHeader(PdfPTable table) {
        Stream.of("IBAN", "DATE", "AMOUNT", "TYPE")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

}
