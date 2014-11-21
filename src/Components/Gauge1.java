package Components;

public class Gauge1 implements Component{
	
	private String variableName;
	private int value;
	private int radius;
	private int xPosition;
	private int yPosition;

	public Gauge1(int diameter, int xPosition, int yPosition, String variableName) {
		
		this.value = this.radius;
		this.variableName = variableName;
		this.radius = diameter / 2;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	@Override
	public void update() {
		
		// Normally, this line would be CANCorder.getValue(this.variableName);
		this.value += 1;
		this.value %= this.radius;
	}

	@Override
	public void render(int[][] pixels) {
		
		for (int y = this.yPosition; y < this.radius * 2 + this.yPosition; y++) {
			for (int x = this.xPosition; x < this.radius * 2 + this.xPosition; x++) {
				
				int xMag = x - (this.xPosition + this.radius);
				int yMag = y - (this.yPosition + this.radius);
				boolean isInCircle = xMag * xMag + yMag * yMag <= this.radius;
				
				if (isInCircle) {
					pixels[y][x] = 0xFFFFFF;
				} else {
					pixels[y][x] = 0x003366;
				}
			}
		}
	}
}
