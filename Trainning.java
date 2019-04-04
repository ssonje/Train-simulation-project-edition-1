import java.awt.*;
import java.applet.*;
import java.util.Scanner;

public class Trainning extends Applet implements Runnable
{
	int x;
	int c;
	Thread t,t1;
    String ch;
	
//============================================initialization of thread================================================    
	public void init()
	{
		
		t=new Thread(this);
		t.start();
		t1=new Thread(this);
		t1.start();
	}
    
//==============================================run meyhod for thread=================================================    
	public void run()
	{
		try
		{

		c=1;
		x=-10;
            for(int i=1;i<150;i++)
			{
				repaint();
                
//===============================================for the green signal=================================================
				
                if(c==1)
				{
					for(int j=1;j<100;j++)
					{
						x=x+4;
						repaint();
						t.sleep(100);
					}
					repaint();
					c=2;
				}
                
//==============================================for the yellow signal=================================================

				if(c==2)
				{
					for(int j=1;j<50;j++)
					{
						x=x+4;
						repaint();
						t.sleep(300);
					}
					repaint();
					c=3;
				}
                
//===============================================for the red signal===================================================

				if(c==3)
				{
					for(int j=1;j<10;j++)
					{
						repaint();
						t.stop();
					}
					repaint();
				}		
			}
           	
        }
			
		catch(Exception e)
		{
		System.out.println();
		}	
	}
    
    int x1,x2,y1,y2;
	
//============================================Assign the values from function=========================================

	public void assign(int x1 , int y1 , int x2 , int y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    
//===================================================draw the delay==================================================

    public void delay()
    {
        try
        {
            Thread.sleep(2); 
        }
        catch(Exception e)
        {
            //System.out.println(e.getMessage);   
        }
    }
    
//=========================================DDA Function==============================================================

    void dda1(Graphics g)
    {
        int dx,dy;
        int len;
        int x,y,i;
        dx=x2-x1;
        dy=y2-y1;

        if(dx>=dy)
        {
            len=Math.abs(x2-x1);
        }
        
        else
        {
            len=Math.abs(y2-y1);
        }
        
        dx=(x2-x1)/len;
        dy=(y2-y1)/len;

        x=x1;
        y=y1;
        i=0;

        while(i<=len)
        {
            g.setColor(Color.black);
            g.fillOval((int)x,(int)y,1,1);
            delay();
            x=x+dx;
            y=y+dy;
            i=i+1;
        }
    }
    
//===========================================BRESENHAM's Function=====================================================

    public void line_algo(Graphics g)
    {
        
        int e;
        int ddx , ddy ;        
        int x , y;
        int i=1;
        
        ddx=Math.abs(x2-x1);
        ddy=Math.abs(y2-y1);
        

        x=x1;
        y=y1;
        
        e=2*ddy-ddx;
        while(i<=ddx)
        {
            g.setColor(Color.black);
            g.fillOval(x,y,1,1);
            delay();
            while(e>=0)
            {
                y=y+1;
                e=e-2*ddx;
            }
            x=x+1;
            e=e+2*ddy;
            i=i+1;
        }
    }

    public void implement(Graphics g)
    {
//========================================draw block 1 yellow block===================================================

    	g.setColor(Color.red);
		g.fillRect(30,100,200,100);
        
//===========================================outline for block 1 yellow===============================================
        
        g.setColor(Color.black);
		g.drawRect(30-1,99,200,100);
        
//============================================draw window 1 and 2 for block 1=========================================
       
        g.setColor(Color.black);
        g.drawRect(30+25,115,35,40);
        g.drawRect(30+110+25,115,36,40);
        
//=========================================draw wheel circle 1========================================================
        
        g.setColor(Color.black);
		g.fillOval(30,200,50,50);
        
//=========================================draw inner circle wheel circle 1===========================================
        
        g.setColor(Color.white);
        g.fillOval(30+15,215,20,20);
		
//===============================================draw wheel circle 2==================================================
		
        g.setColor(Color.black);
		g.fillOval((30+150),200,50,50);
        
//===============================================draw inner circle wheel circle 2=====================================
        
        g.setColor(Color.white);
        g.fillOval(30+15+150,215,20,20);
        
//==============================================draw block 2 yellow block=============================================
		
        g.setColor(Color.red);
		g.fillRect(30+300,100,200,100);
        
//==========================================outline for block 1 yellow================================================
        
        g.setColor(Color.black);
		g.drawRect(30+300-1,99,200,100);
        
//=============================================draw window 1 and 2 for block 2========================================
        
        g.setColor(Color.black);
        g.drawRect(30+25+300,115,35,40);
        g.drawRect(30+110+25+300,115,36,40);

//===============================================draw wheel circle 3==================================================
		
        g.setColor(Color.black);
		g.fillOval(30+300,200,50,50);
        
//=======================================draw inner circle wheel circle3==============================================
        
        g.setColor(Color.white);
        g.fillOval(30+15+300,215,20,20);
		
//=============================================draw wheel circle 4====================================================
		
        g.setColor(Color.black);
		g.fillOval((30+300+150),200,50,50);
        
//=========================================draw inner circle wheel circle 4===========================================
        
        g.setColor(Color.white);
        g.fillOval(30+15+300+150,215,20,20);
	
//==============================================Engine curve start====================================================
        
        g.setColor(Color.yellow);
		g.fillArc((30+450),100,100,100,270,180);
        
        g.setColor(Color.black);
        g.drawArc((30+450),100,100-1,100-1,270,180);
		
//********************************************draw line using dda algorithm*******************************************
            
//==============================================stand line engine=====================================================
            
            assign(30+500,75,30+500,100);
            dda1(g);
            
            assign(30+501,75,30+501,100);
            dda1(g);
            
            assign(30+502,75,30+502,100);
            dda1(g);
            
            assign(30+503,75,30+503,100);
            dda1(g);
            
            assign(30+504,75,30+504,100);
            dda1(g);
            
            assign(30+505,75,30+505,100);
            dda1(g);
            
            assign(30+506,75,30+506,100);
            dda1(g);
            
            assign(30+507,75,30+507,100);
            dda1(g);
        
//===============================================signal line vertical=================================================
            
            g.drawLine(1500,50,1500,240);
            g.drawLine(1501,50,1501,240);
            g.drawLine(1502,50,1502,240);
            g.drawLine(1503,50,1503,240);
            g.drawLine(1504,50,1504,240);
            
//***************************************draw line using bresanham's algorithm****************************************
        
//============================================draw window line for block 1============================================
            
            assign((30+25),128,(30+60),128);
            line_algo(g);
            
            assign((30+25),143,(30+60),143);
            line_algo(g);
            
//============================================draw window line for block 1============================================
            
            assign((30+115+20),128,(30+115+57),128);
            line_algo(g);
            
            assign((30+115+20),143,(30+115+57),143);
            line_algo(g);

//===============================================draw connection line=================================================
            
            g.drawLine((30+200),150,(30+300),150);
            g.drawLine((30+200),151,(30+300),151);
            g.drawLine((30+200),152,(30+300),152);
            g.drawLine((30+200),153,(30+300),153);
            g.drawLine((30+200),154,(30+300),154);
            g.drawLine((30+200),155,(30+300),155);
            g.drawLine((30+200),156,(30+300),156);
            g.drawLine((30+200),157,(30+300),157);
            g.drawLine((30+200),158,(30+300),158);
            g.drawLine((30+200),159,(30+300),159);
            g.drawLine((30+200),160,(30+300),160);
            
//============================================draw window line for block 2============================================
            
            assign((30+25+300),128,(30+60+300),128);
            line_algo(g);
            
            assign((30+25+300),143,(30+60+300),143);
            line_algo(g);
            
//============================================draw window line for block 2============================================
           
            assign((30+115+20+300),128,(30+115+57+300),128);
            line_algo(g);
            
            assign((30+25+110+300),143,(30+60+110+300),143);
            line_algo(g);

//=================================================upper line - 1=====================================================
            
            assign(30+490,75,30+500,75);
            line_algo(g);
            
            assign(30+491,75,30+501,75);
            line_algo(g);
            
            assign(30+492,75,30+502,75);
            line_algo(g);
            
            assign(30+493,75,30+503,75);
            line_algo(g);
            
            assign(30+494,75,30+504,75);
            line_algo(g);
            
            assign(30+495,75,30+505,75);
            line_algo(g);
            
            assign(30+496,75,30+506,75);
            line_algo(g);
            
            assign(30+497,75,30+507,75);
            line_algo(g);
            
            assign(30+490,76,30+500,76);
            line_algo(g);
            
            assign(30+491,76,30+501,76);
            line_algo(g);
            
            assign(30+492,76,30+502,76);
            line_algo(g);
            
            assign(30+493,76,30+503,76);
            line_algo(g);
            
            assign(30+494,76,30+504,76);
            line_algo(g);
            
            assign(30+495,76,30+505,76);
            line_algo(g);
            
            assign(30+496,76,30+506,76);
            line_algo(g);
            
            assign(30+497,76,30+507,76);
            line_algo(g);

//=================================================upper line - 2=====================================================
            
            assign(30+465,75,30+475,75);
            line_algo(g);
            
            assign(30+466,75,30+476,75);
            line_algo(g);
            
            assign(30+467,75,30+477,75);
            line_algo(g);
            
            assign(30+468,75,30+478,75);
            line_algo(g);
            
            assign(30+469,75,30+479,75);
            line_algo(g);
            
            assign(30+470,75,30+480,75);
            line_algo(g);
            
            assign(30+471,75,30+481,75);
            line_algo(g);
            
            assign(30+472,75,30+482,75);
            line_algo(g);
            
            assign(30+465,76,30+475,76);
            line_algo(g);
            
            assign(30+466,76,30+476,76);
            line_algo(g);
            
            assign(30+467,76,30+477,76);
            line_algo(g);
            
            assign(30+468,76,30+478,76);
            line_algo(g);
            
            assign(30+469,76,30+479,76);
            line_algo(g);
            
            assign(30+470,76,30+480,76);
            line_algo(g);
            
            assign(30+471,76,30+481,76);
            line_algo(g);
            
            assign(30+472,76,30+482,76);
            line_algo(g);

//====================================================upper line - 3==================================================
            
            assign(30+440,75,30+450,75);
            line_algo(g);
            
            assign(30+441,75,30+451,75);
            line_algo(g);
            
            assign(30+442,75,30+452,75);
            line_algo(g);
            
            assign(30+443,75,30+453,75);
            line_algo(g);
            
            assign(30+444,75,30+454,75);
            line_algo(g);
            
            assign(30+445,75,30+455,75);
            line_algo(g);
            
            assign(30+446,75,30+456,75);
            line_algo(g);
            
            assign(30+447,75,30+457,75);
            line_algo(g);
            
            assign(30+440,76,30+450,76);
            line_algo(g);
            
            assign(30+441,76,30+451,76);
            line_algo(g);
            
            assign(30+442,76,30+452,76);
            line_algo(g);
            
            assign(30+443,76,30+453,76);
            line_algo(g);
            
            assign(30+444,76,30+454,76);
            line_algo(g);
            
            assign(30+445,76,30+455,76);
            line_algo(g);
            
            assign(30+446,76,30+456,76);
            line_algo(g);
            
            assign(30+447,76,30+457,76);
            line_algo(g);
            
//===============================================draw platform line===================================================
            
            g.drawLine(0,249,1920,249);
            g.drawLine(0,250,1920,250);
            g.drawLine(0,251,1920,251);
            g.drawLine(0,252,1920,252);
            g.drawLine(0,253,1920,253);
            g.drawLine(0,254,1920,254);

//==============================================signal line horizontal================================================
            
            assign(1485,240,1518,240);
            line_algo(g);
            
            assign(1485,241,1518,241);
            line_algo(g);
            
            assign(1485,242,1518,242);
            line_algo(g);
            
            assign(1485,243,1518,243);
            line_algo(g);
            
            assign(1485,244,1518,244);
            line_algo(g);
            
            assign(1485,245,1518,245);
            line_algo(g);
            
            assign(1485,246,1518,246);
            line_algo(g);
            
            assign(1485,247,1518,247);
            line_algo(g);
            
            assign(1485,248,1518,248);
            line_algo(g);
            
            assign(1485,249,1518,249);
            line_algo(g);

//==============================================signal line horizontal red============================================
            
            assign(1450,49,1504,49);
            line_algo(g);
            
            assign(1450,48,1504,48);
            line_algo(g);
            
            assign(1450,47,1504,47);
            line_algo(g);
            
//===========================================signal line horizontal yellow============================================
            
            assign(1450,49+50+3,1504,49+50+3);
            line_algo(g);
            
            assign(1450,48+50+3,1504,48+50+3);
            line_algo(g);
            
            assign(1450,47+50+3,1504,47+50+3);
            line_algo(g);

//============================================signal line horizontal green============================================
            
            assign(1450,49+50+50+4,1504,49+50+50+4);
            line_algo(g);
            
            assign(1450,48+50+50+4,1504,48+50+50+4);
            line_algo(g);
            
            assign(1450,47+50+50+4,1504,47+50+50+4);
            line_algo(g);
            
//============================================draw platform line======================================================
            
            g.drawLine(0,249,1920,249);
            g.drawLine(0,250,1920,250);
            g.drawLine(0,251,1920,251);
            g.drawLine(0,252,1920,252);
            g.drawLine(0,253,1920,253);
            g.drawLine(0,254,1920,254);
            
//=================================================CLEAR SCREEN=======================================================
            Dimension d = getSize();
    	    g.setColor(Color.WHITE);
    	    g.fillRect(0, 0, d.width, d.height);
    
    }
    

	public void paint(Graphics g)
	{

//===================================================Main code========================================================
            
            if(x==-6)
            {
                implement(g);
                x=10;
            }
            
//============================================draw block 1 yellow block..=============================================
                
                g.setColor(Color.red);
                g.fillRect(x,100,200,100);

//============================================outline for block 1 yellow==============================================
                
                g.setColor(Color.black);
                g.drawRect(x-1,99,200,100);

//=========================================draw window 1 and 2 for block 1============================================
                
                g.setColor(Color.black);
                g.drawRect(x+25,115,35,40);
                g.drawRect(x+110+25,115,36,40);

//============================================draw window line for block 1============================================
                
                g.drawLine((x+25),128,(x+60),128);
                g.drawLine((x+25),143,(x+60),143);

//============================================draw windoe line for block 1============================================
                
                g.drawLine((x+115+20),128,(x+115+57),128);
                g.drawLine((x+115+20),143,(x+115+57),143);

//============================================draw wheel circle 1=====================================================
                
                g.setColor(Color.black);
                g.fillOval(x,200,50,50);

//============================================draw inner circle wheel circle 1========================================
                
                g.setColor(Color.white);
                g.fillOval(x+15,215,20,20);

//============================================draw wheel circle 2=====================================================
                
                g.setColor(Color.black);
                g.fillOval((x+150),200,50,50);

//=========================================draw inner circle wheel circle 2===========================================
                
                g.setColor(Color.white);
                g.fillOval(x+15+150,215,20,20);

//============================================draw connection line====================================================
                
                g.setColor(Color.black);
                g.drawLine((x+200),150,(x+300),150);
                g.drawLine((x+200),151,(x+300),151);
                g.drawLine((x+200),152,(x+300),152);
                g.drawLine((x+200),153,(x+300),153);
                g.drawLine((x+200),154,(x+300),154);
                g.drawLine((x+200),155,(x+300),155);
                g.drawLine((x+200),156,(x+300),156);
                g.drawLine((x+200),157,(x+300),157);
                g.drawLine((x+200),158,(x+300),158);
                g.drawLine((x+200),159,(x+300),159);
                g.drawLine((x+200),160,(x+300),160);

//============================================draw block 2 yellow block==============================================
                
                g.setColor(Color.red);
                g.fillRect(x+300,100,200,100);

//============================================outline for block 1 yellow==============================================
                
                g.setColor(Color.black);
                g.drawRect(x+300-1,99,200,100);

//=========================================draw window 1 and 2 for block 2============================================
                
                g.setColor(Color.black);
                g.drawRect(x+25+300,115,35,40);
                g.drawRect(x+110+25+300,115,36,40);

//============================================draw window line for block 2============================================
                
                g.drawLine((x+25+300),128,(x+60+300),128);
                g.drawLine((x+25+300),143,(x+60+300),143);


//============================================draw window line for block 2============================================
                
                g.drawLine((x+115+20+300),128,(x+115+57+300),128);
                g.drawLine((x+25+110+300),143,(x+60+110+300),143);

//============================================draw wheel circle 3=====================================================
                
                g.setColor(Color.black);
                g.fillOval(x+300,200,50,50);

//==========================================draw inner circle wheel circle 3==========================================
                
                g.setColor(Color.white);
                g.fillOval(x+15+300,215,20,20);

//============================================draw wheel circle 4=====================================================
                
                g.setColor(Color.black);
                g.fillOval((x+300+150),200,50,50);

//============================================draw inner circle wheel circle 4========================================
                
                g.setColor(Color.white);
                g.fillOval(x+15+300+150,215,20,20);

//============================================Engine curve start======================================================
                
                g.setColor(Color.yellow);
                g.fillArc((x+450),100,100,100,270,180);

                g.setColor(Color.black);
                g.drawArc((x+450),100,100-1,100-1,270,180);
                
//==============================================draw platform line====================================================
                
                g.drawLine(0,249,1920,249);
                g.drawLine(0,250,1920,250);
                g.drawLine(0,251,1920,251);
                g.drawLine(0,252,1920,252);
                g.drawLine(0,253,1920,253);
                g.drawLine(0,254,1920,254);

//============================================stand line engine=======================================================
                
                g.setColor(Color.black);
                g.drawLine(x+500,75,x+500,100);
                g.drawLine(x+501,75,x+501,100);
                g.drawLine(x+502,75,x+502,100);
                g.drawLine(x+503,75,x+503,100);
                g.drawLine(x+504,75,x+504,100);
                g.drawLine(x+505,75,x+505,100);
                g.drawLine(x+506,75,x+506,100);
                g.drawLine(x+507,75,x+507,100);

//============================================upper line - 1==========================================================
                
                g.setColor(Color.black);
                g.drawLine(x+490,75,x+500,75);
                g.drawLine(x+491,75,x+501,75);
                g.drawLine(x+492,75,x+502,75);
                g.drawLine(x+493,75,x+503,75);
                g.drawLine(x+494,75,x+504,75);
                g.drawLine(x+495,75,x+505,75);
                g.drawLine(x+496,75,x+506,75);
                g.drawLine(x+497,75,x+507,75);

                g.setColor(Color.black);
                g.drawLine(x+490,76,x+500,76);
                g.drawLine(x+491,76,x+501,76);
                g.drawLine(x+492,76,x+502,76);
                g.drawLine(x+493,76,x+503,76);
                g.drawLine(x+494,76,x+504,76);
                g.drawLine(x+495,76,x+505,76);
                g.drawLine(x+496,76,x+506,76);
                g.drawLine(x+497,76,x+507,76);

//============================================upper line - 2==========================================================
                
                g.setColor(Color.black);
                g.drawLine(x+465,75,x+475,75);
                g.drawLine(x+466,75,x+476,75);
                g.drawLine(x+467,75,x+477,75);
                g.drawLine(x+468,75,x+478,75);
                g.drawLine(x+469,75,x+479,75);
                g.drawLine(x+470,75,x+480,75);
                g.drawLine(x+471,75,x+481,75);
                g.drawLine(x+472,75,x+482,75);

                g.setColor(Color.black);
                g.drawLine(x+465,76,x+475,76);
                g.drawLine(x+466,76,x+476,76);
                g.drawLine(x+467,76,x+477,76);
                g.drawLine(x+468,76,x+478,76);
                g.drawLine(x+469,76,x+479,76);
                g.drawLine(x+470,76,x+480,76);
                g.drawLine(x+471,76,x+481,76);
                g.drawLine(x+472,76,x+482,76);

//================================================upper line - 3======================================================
                
                g.setColor(Color.black);
                g.drawLine(x+440,75,x+450,75);
                g.drawLine(x+441,75,x+451,75);
                g.drawLine(x+442,75,x+452,75);
                g.drawLine(x+443,75,x+453,75);
                g.drawLine(x+444,75,x+454,75);
                g.drawLine(x+445,75,x+455,75);
                g.drawLine(x+446,75,x+456,75);
                g.drawLine(x+447,75,x+457,75);

                g.setColor(Color.black);
                g.drawLine(x+440,76,x+450,76);
                g.drawLine(x+441,76,x+451,76);
                g.drawLine(x+442,76,x+452,76);
                g.drawLine(x+443,76,x+453,76);
                g.drawLine(x+444,76,x+454,76);
                g.drawLine(x+445,76,x+455,76);
                g.drawLine(x+446,76,x+456,76);
                g.drawLine(x+447,76,x+457,76);

//============================================signal line verticle====================================================
                
                g.setColor(Color.black);
                g.drawLine(1500,50,1500,240);
                g.drawLine(1501,50,1501,240);
                g.drawLine(1502,50,1502,240);
                g.drawLine(1503,50,1503,240);
                g.drawLine(1504,50,1504,240);

//============================================signal line horizontal==================================================        
                g.setColor(Color.black);
                g.drawLine(1485,240,1518,240);
                g.drawLine(1485,241,1518,241);
                g.drawLine(1485,242,1518,242);
                g.drawLine(1485,243,1518,243);
                g.drawLine(1485,244,1518,244);
                g.drawLine(1485,245,1518,245);
                g.drawLine(1485,246,1518,246);
                g.drawLine(1485,247,1518,247);
                g.drawLine(1485,248,1518,248);
                g.drawLine(1485,249,1518,249);

//============================================signal line horizontal red==============================================
                
                g.setColor(Color.black);
                g.drawLine(1450,49,1504,49);
                g.drawLine(1450,48,1504,48);
                g.drawLine(1450,47,1504,47);

//===========================================signal line horizontal yellow============================================
                
                g.setColor(Color.black);
                g.drawLine(1450,49+50+3,1504,49+50+3);
                g.drawLine(1450,48+50+3,1504,48+50+3);
                g.drawLine(1450,47+50+3,1504,47+50+3);

//============================================signal line horizontal green============================================
                
                g.setColor(Color.black);
                g.drawLine(1450,49+50+50+4,1504,49+50+50+4);
                g.drawLine(1450,48+50+50+4,1504,48+50+50+4);
                g.drawLine(1450,47+50+50+4,1504,47+50+50+4);
                
                
//===============================================for the green signal=================================================
                
                if(c==1)
                {
                     g.setColor(Color.green);
                     g.fillOval(1450,200-50+4,50,50);

                     g.setColor(Color.black);
                     g.drawOval(1450,200-50+4,50,50);

                }
                
//===============================================for the yellow signal================================================
                
                else if(c==2)
                { 			
                     g.setColor(Color.yellow);
                     g.fillOval(1450,150-50+3,50,50);

                     g.setColor(Color.black);
                     g.drawOval(1450,150-50+3,50,50);		

                }
                
//===============================================for the red signal=================================================
                
                else if(c==3)
                {
                     g.setColor(Color.red);
                     g.fillOval(1450,100-50,50,50);

                     g.setColor(Color.black);
                     g.drawOval(1450,100-50,50,50);
                }
            
    }
}
    
/*<applet code='Trainning' height=1000 width=2000></applet>*/