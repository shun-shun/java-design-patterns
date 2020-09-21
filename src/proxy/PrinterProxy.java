package proxy;

public class PrinterProxy implements Printable {
	private String name;
	private Printer real;
	public PrinterProxy() {
	}
	public PrinterProxy(String name) {
		this.name = name;
	}
	@Override
	public void setPrinterName(String name) {
		if (real != null) {
			real.setPrinterName(name);
		}
		this.name = name;
	}

	@Override
	public String getPrinterName() {
		return name;
	}

	@Override
	public void print(String msg) {
		realize();
		real.print(msg);
	}
	private void realize() {
		if (real == null) {
			real = new Printer(name);
		}
	}

}
