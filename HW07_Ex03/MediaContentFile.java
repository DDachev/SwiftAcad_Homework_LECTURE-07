package bg.swift.HW07_Ex03;


public class MediaContentFile extends ContentFile {

	public MediaContentFile(String name, String location, String content) {
		super(name, location, content);
	}

	@Override
	protected void execute() {
		if(!super.getDelete()) {
			char a = '\u266B';
			String symbol = "";
			for(int i = 0; i < 3; i++) {
				symbol += a;
			}
			String text = super.getContent();
			System.out.println(symbol + " " + super.getLocation() + "/" + super.getName());
			System.out.println(text.substring(8, text.length()));
		}
	}
}
