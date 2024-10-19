package edu.nd.cse.paradigms;
import java.awt.image.BufferedImage;

public class PEScreen {
    private int width, height;
    private int bg;
    private BufferedImage image;
    private int[][] pixels;
	
    //public PEScreen(int width, int height)
    public PEScreen(int width, int height){
        this.width = width;
        this.height = height;
        this.bg = 0x22CC11; 
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        pixels = new int[width][height];
        clear();
    }
	
    //public void setPixel(int px, int py, int color)
    public void setPixel(int px, int py, int color){
        if(inBounds(px, py)){
            pixels[px][py] = color;
            image.setRGB(px, py, color);
        }
    }
    
    //public void clear()
    public void clear(){
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                setPixel(x, y, bg);
            }
        }
    }
	
    //public boolean inBounds(int px, int py)
    public boolean inBounds(int px, int py){
        return (px >= 0 && px < width) && (py >= 0 && py < height);
    }
	
    //public void renderWorldObject(PEWorldObject wo)
    public void renderWorldObject(PEWorldObject wo){}

    //public BufferedImage render()
    public BufferedImage render(){
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, pixels[x][y]);
            }
        }
        return image;
    }
}
