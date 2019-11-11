/*
    Name: Justin Chhay
    Date: November 7th, 2019
    Teacher: Mr. Afsari-Nejad
    Description: Program solves for a specified variable in the Acceleration Formula in Physics.

    PLEASE READ BEFORE RUNNING:
    
	I had to import java.lang.* in order to parse the double variables into floats.
	    This is so that if we get a number with a long decimal value, it will only
	    display the answer, up to 6-7 decimal places (because it is now parsed into a float)

	PauseProgram Method will always run at the start of intro, askData, and display methods.
	    Pausing, and then resuming will just call the previous method, asking if you want to
	    pause again. At this point you can just click ANYTHING OTHER THAN YES to continue on with the program.

	Because the rubric stated that ALL inputs must be error-trapped, I had to include a lot of
	    try catch loops to meet the expectations of the assignment on the rubric. Input Errors
	    could be: Wrong Data Type

	My format for MOST comments will be:
	    //TypeOfCode - Explanation
	For example...
	    //Comment - This comment explains my formatting for comments
*/

// The "JustinChhay_PhysicsFormulaSolver" class.
import java.awt.*;
import hsa.Console;
import javax.swing.*; //Allows for JOptionPane usage
import java.lang.*; // For Parsing

public class JustinChhay_PhysicsFormulaSolver
{
    Console c;           // The output console

    //Global/Instance Variables
    String option;              //String - User Input for Choices
    double a;                   //Double - Numeric Value for Acceleration
    double vF;                  //Double - Numeric Value for Final Velocity
    double vI;                  //Double - Numeric Value for Initial Velocity
    double t;                   //Double - Numeric Value for Time
    boolean pIntro = false;     //Boolean Value - Makes sure user returns to previous method, intro(); from pausing
    boolean pAskData = false;   //Boolean Value - Makes sure user returns to previous method, askData(); from pausing
    boolean pDisplay = false;   //Boolean Value - Makes sure user returns to previous method, display(); from pausing

    //Instance/Class GRAPHICS Variables
    Color background = new Color (47, 133, 62);             //Color - variable for background (needed for erase)
    Font title = new Font ("MonoSpaced", Font.BOLD, 28);   //Font - Variable for title
    Font method = new Font ("MonoSpaced", Font.BOLD, 30);  //Font - Variable for method indicator text
    Font text = new Font ("MonoSpaced", Font.BOLD, 20);    //Font - Variable for general text


    
    //Title Method - Draws Program Title to Graphics Window
    public void title ()
    {
	//Local Color Variable
	Color titleBorder = new Color (240, 240, 240);

	//Clear Graphics on Screen
	c.clear ();

	//Program Background
	c.setColor (background);
	c.fillRect (0, 0, 640, 500);

	//Title Border
	c.setColor (titleBorder);
	c.fillRect (0, 20, 640, 75);

	//Program Title
	c.setFont (title);
	c.setColor (Color.black);
	c.drawString ("ACCELERATION FORMULA CALCULATOR", 60, 65);

	//Program Credits
	c.setColor (Color.white);
	c.setFont (new Font ("SansSerif", Font.BOLD, 14));
	c.drawString ("programmed by Justin Chhay", 25, 480);
    }



    //Intro Method - Introduces User to Program and Asks for Option
    public void intro ()
    {
	//Default Program Title and Background
	title ();

	//Indicates which Method the user is on
	c.setFont (method);
	c.drawString ("INTRODUCTION", 400, 480);

	//Pause Statement
	c.setFont (text);
	c.drawString ("Would you like to PAUSE?", 180, 280);


	//JOptionPane - Asks if user wants to pause program
	int pause = JOptionPane.showConfirmDialog (null, "Would you like to PAUSE the program?");

	//If Structure - Will run pauseProgram(); or continue with intro(); depending on previous user input
	if (pause == JOptionPane.OK_OPTION)
	{
	    pIntro = true;  //Ensures that user returns back to intro method
	    pauseProgram ();
	}
	else if (pause == JOptionPane.NO_OPTION || pause == JOptionPane.CANCEL_OPTION || pause == JOptionPane.CLOSED_OPTION)
	{
	    //Erase - Needed to erase pause statement (can only use clear(); in title)
	    c.setColor (background);
	    c.drawString ("Would you like to PAUSE?", 180, 280);

	    //Text - Program Options
	    c.setFont (text);
	    c.setColor (Color.white);
	    c.drawString ("A = (Vf - Vi) / T", 220, 150);
	    c.drawString ("Choose: 1) Solve for Acceleration", 50, 200);
	    c.drawString ("2) Solve for Final Velocity", 146, 250);
	    c.drawString ("3) Solve for Initial Velocity", 146, 300);
	    c.drawString ("4) Solve for Time", 146, 350);
	    c.drawString ("Press ANY other key to EXIT ", 146, 400);

	    //Try Catch Loop - ErrorTrap FOR OPTION
	    try
	    {
		//JOptionPane - Asks for user input on which variable to solve for, OR to call goodbye();
		option = JOptionPane.showInputDialog (null, "CHOOSE OPTION:\n  1 for solving the Acceleration\n  2 for solving the Final Velocity\n  3 for solving the Initial Velocity\n  4 for solving the Time\nEnter ANY OTHER key to EXIT...");
		if (option.equals ("1") || option.equals ("2") || option.equals ("3") || option.equals ("4"))
		{
		    askData ();
		}
		else
		{
		    goodbye ();
		}
	    }
	    catch (Exception e)
	    {
		//Error Trap - If user closes or cancels input, will call intro method again
		JOptionPane.showMessageDialog (null, "Invalid Input!");
		intro ();
	    }
	}

    }



    //AskData Method - Asks user for variable input
    private void askData ()
    {
	//Default Program Title and Background
	title ();

	//Indicates which Method the user is on
	c.setFont (method);
	c.drawString ("AskData", 450, 480);

	//Pause Statement
	c.setFont (text);
	c.drawString ("Would you like to PAUSE?", 180, 280);

	//JOptionPane - Asks if user wants to pause program
	int pause = JOptionPane.showConfirmDialog (null, "Would you like to PAUSE the program?");

	//If Structure - Will run pauseProgram(); or continue with askData(); depending on previous user input
	if (pause == JOptionPane.OK_OPTION)
	{
	    pAskData = true;  //Ensures that user returns back to askData method
	    pauseProgram ();
	}
	else if (pause == JOptionPane.NO_OPTION || pause == JOptionPane.CANCEL_OPTION || pause == JOptionPane.CLOSED_OPTION)
	{
	    //Needed to erase pause statement (can only use clear(); in title)
	    c.setColor (background);
	    c.drawString ("Would you like to PAUSE?", 180, 280);
	    c.setColor (Color.white);

	    //If Structure - Depending on user input for String var option, program will execute appropriate output
	    if (option.equals ("1"))
	    {
		//General Text
		c.drawString ("Please enter values to find Acceleration!", 80, 200);
		c.drawString ("Final Velocity:", 150, 250);
		c.drawString ("Initial Velocity:", 150, 300);
		c.drawString ("Time:", 150, 350);

		//TryCatch and JOptionPane - Asks for input for values, and error-traps incorrect input for EACH specific input variable
		try //Error Trap - final velocity
		{
		    vF = Double.parseDouble (JOptionPane.showInputDialog (null, "Please input a number for the Final Velocity..."));
		    c.drawString (vF + " m/s", 400, 250);
		}
		catch (Exception e)
		{
		    JOptionPane.showMessageDialog (null, "Please input the correct data type for the Final Velocity.");
		    askData ();
		}

		try //Error Trap - initial velocity
		{
		    vI = Double.parseDouble (JOptionPane.showInputDialog (null, "Please input a number for the Initial Velocity..."));
		    c.drawString (vI + " m/s", 400, 300);
		}
		catch (Exception e)
		{
		    JOptionPane.showMessageDialog (null, "Please input the correct data type for the Initial Velocity.");
		    askData ();
		}

		try //Error Trap - time
		{
		    t = Double.parseDouble (JOptionPane.showInputDialog (null, "Please input a number for the Time..."));
		    c.drawString (t + " s", 400, 350);
		}
		catch (Exception e)
		{
		    JOptionPane.showMessageDialog (null, "Please input the correct data type for the Time.");
		    askData ();
		}
	    }
	    else if (option.equals ("2"))
	    {
		//General Text
		c.drawString ("Please enter values to find Final Velocity!", 80, 200);
		c.drawString ("Initial Velocity:", 150, 250);
		c.drawString ("Time:", 150, 300);
		c.drawString ("Acceleration:", 150, 350);

		try //Error Trap - initial velocity
		{
		    vI = Double.parseDouble (JOptionPane.showInputDialog (null, "Please input a number for the Initial Velocity..."));
		    c.drawString (vI + " m/s", 400, 250);
		}
		catch (Exception e)
		{
		    JOptionPane.showMessageDialog (null, "Please input the correct data type for the Initial Velocity.");
		    askData ();
		}

		try  //Error Trap - time
		{
		    t = Double.parseDouble (JOptionPane.showInputDialog (null, "Please input a number for the Time..."));
		    c.drawString (t + " s", 400, 300);
		}
		catch (Exception e)
		{
		    JOptionPane.showMessageDialog (null, "Please input the correct data type for the Time.");
		    askData ();
		}

		try  //Error Trap - acceleration
		{
		    a = Double.parseDouble (JOptionPane.showInputDialog (null, "Please input a number for the Acceleration..."));
		    c.drawString (a + " m/s^2", 400, 350);
		}
		catch (Exception e)
		{
		    JOptionPane.showMessageDialog (null, "Please input the correct data type for Acceleration.");
		    askData ();
		}
	    }
	    else if (option.equals ("3"))
	    {
		//General Text
		c.drawString ("Please enter values to find Initial Velocity!", 80, 200);
		c.drawString ("Final Velocity:", 150, 250);
		c.drawString ("Time:", 150, 300);
		c.drawString ("Acceleration:", 150, 350);

		try  //Error Trap - Final Velocity
		{
		    vF = Double.parseDouble (JOptionPane.showInputDialog (null, "Please input a number for the Final Velocity..."));
		    c.drawString (vF + " m/s", 400, 250);

		}
		catch (Exception e)
		{
		    JOptionPane.showMessageDialog (null, "Please input the correct data type for the Final Velocity.");
		    askData ();
		}

		try  //Error Trap - time
		{
		    t = Double.parseDouble (JOptionPane.showInputDialog (null, "Please input a number for the Time..."));
		    c.drawString (t + " s", 400, 300);
		}
		catch (Exception e)
		{
		    JOptionPane.showMessageDialog (null, "Please input the correct data type for the Time.");
		    askData ();
		}

		try  //Error Trap - acceleration
		{
		    a = Double.parseDouble (JOptionPane.showInputDialog (null, "Please input a number for the Acceleration..."));
		    c.drawString (a + " m/s^2", 400, 350);
		}
		catch (Exception e)
		{
		    JOptionPane.showMessageDialog (null, "Please input the correct data type for the Acceleration.");
		    askData ();
		}
	    }
	    else if (option.equals ("4"))
	    {
		//General Text
		c.drawString ("Please enter values to find Time!", 80, 200);
		c.drawString ("Final Velocity:", 150, 250);
		c.drawString ("Initial Velocity:", 150, 300);
		c.drawString ("Acceleration:", 150, 350);

		try   //Error Trap - final velocity
		{
		    vF = Double.parseDouble (JOptionPane.showInputDialog (null, "Please input a number for the Final Velocity..."));
		    c.drawString (vF + " m/s", 400, 250);

		}
		catch (Exception e)
		{
		    JOptionPane.showMessageDialog (null, "Please input the correct data type for the Final Velocity.");
		    askData ();
		}

		try   //Error Trap - initial velocity
		{
		    vI = Double.parseDouble (JOptionPane.showInputDialog (null, "Please input a number for the Initial Velocity..."));
		    c.drawString (vI + " m/s", 400, 300);
		}
		catch (Exception e)
		{
		    JOptionPane.showMessageDialog (null, "Please input the correct data type for the Initial Velocity.");
		    askData ();
		}

		try   //Error Trap - acceleration
		{
		    a = Double.parseDouble (JOptionPane.showInputDialog (null, "Please input a number for the Acceleration..."));
		    c.drawString (a + " m/s^2", 400, 350);
		}
		catch (Exception e)
		{
		    JOptionPane.showMessageDialog (null, "Please input the correct data type for the Acceleration.");
		    askData ();
		}
	    }
	}


	//JOptionPane - Waits for user to click OK btn to advance
	JOptionPane.showMessageDialog (null, "Click OK to ADVANCE.");
	display ();
    }



    //Display Method - Displays answer using calculations with previous variable input
    public void display ()
    {
	//Default Program Title and Background
	title ();

	//Indicates current method user is on
	c.setFont (method);
	c.drawString ("Display", 450, 480);

	//Pause Statement
	c.setFont (text);
	c.drawString ("Would you like to PAUSE?", 180, 280);

	//JOptionPane - Asks if user wants to pause program
	int pause = JOptionPane.showConfirmDialog (null, "Would you like to PAUSE the program?");

	//If Structure - Will run pauseProgram(); or continue with display(); depending on previous user input
	if (pause == JOptionPane.OK_OPTION)
	{
	    pDisplay = true; //Ensures that user returns back to display method
	    pauseProgram ();
	}
	else if (pause == JOptionPane.NO_OPTION || pause == JOptionPane.CANCEL_OPTION || pause == JOptionPane.CLOSED_OPTION)
	{
	    //Needed to erase pause statement (can only use clear(); in title)
	    c.setColor (background);
	    c.drawString ("Would you like to PAUSE?", 180, 280);
	    c.setColor (Color.white);

	    //If Structure - Depending on value of String var option, program will output appropriate answer and calculations
	    if (option.equals ("1")) //Finds Acceleration
	    {
		//Formula for Acceleration
		a = (vF - vI) / t;
		
		//Parsing
		float a1 = (float)a;

		//General Text - Outputs given values from user input
		c.drawString ("With these values:", 40, 140);
		c.drawString ("Final Velocity: " + vF + " m/s", 50, 180);
		c.drawString ("Initial Velocity: " + vI + " m/s", 50, 210);
		c.drawString ("Time: " + t + " s", 50, 240);

		//Visual EQUATION of formula
		c.drawString ("Acceleration = (" + vF + " - " + vI + ")", 150, 300);
		c.drawLine (320, 310, 470, 310);
		c.drawString ("" + t, 375, 330);

		//Conclusion
		c.drawString ("Therefore, Acceleration must be " + a1 + " m/s^2.", 50, 420);
	    }
	    else if (option.equals ("2")) //Finds Final Velocity
	    {
		//Formula for Final Velocity
		vF = t * a + vI;
		
		//Parsing
		float vF1 = (float)vF;

		//General Text - Outputs given values from user input
		c.drawString ("With these values:", 40, 140);
		c.drawString ("Initial Velocity: " + vI + " m/s", 50, 180);
		c.drawString ("Time: " + t + " s", 50, 210);
		c.drawString ("Acceleration: " + a + " m/s^2", 50, 240);

		//Visual EQUATION of formula
		c.drawString ("Final Velocity = " + t + " * " + a + " + " + vI, 150, 300);

		//Conclusion
		c.drawString ("Therefore, Final Velocity must be " + vF1 + " m/s.", 50, 420);
	    }
	    else if (option.equals ("3")) //Finds Initial Velocity
	    {
		//Formula for Initial Velocity
		vI = vF - t * a;
		
		//Parsing
		float vI1 = (float)vI;
		
		//General Text - Outputs given values from user input
		c.drawString ("With these values:", 40, 140);
		c.drawString ("Final Velocity: " + vF + " m/s", 50, 180);
		c.drawString ("Time: " + t + " s", 50, 210);
		c.drawString ("Acceleration: " + a + " m/s^2", 50, 240);

		//Visual EQUATION of formula
		c.drawString ("Initial Velocity = " + vF + " - " + t + " * " + a, 80, 300);

		//Conclusion
		c.drawString ("Therefore, Initial Velocity must be " + vI1 + " m/s^2.", 50, 420);
	    }
	    else if (option.equals ("4")) //Finds Time
	    {
		//Formula for Time
		t = (vF - vI) / a;
		
		//Parsing
		float t1 = (float)t;
		
		//General Text - Outputs given values from user input
		c.drawString ("With these values:", 40, 140);
		c.drawString ("Final Velocity: " + vF + " m/s", 50, 180);
		c.drawString ("Initial Velocity: " + vI + " m/s", 50, 210);
		c.drawString ("Acceleration: " + a + " m/s^2", 50, 240);

		//Visual EQUATION of formula
		c.drawString ("Time = (" + vF + " - " + vI + ")", 80, 300);
		c.drawLine (160, 310, 300, 310);
		c.drawString ("" + a, 215, 330);

		//Conclusion
		c.drawString ("Therefore, Time must be " + t1 + " s.", 50, 420);
	    }
	}

	//Needed so that the program allows user to stop and view output
	JOptionPane.showMessageDialog (null, "Click OK to ADVANCE.");
	goodbye ();
    }



    //PauseProgram Method - Allows user to pause and continue program
    public void pauseProgram ()
    {
	//Default Program Title and Background
	title ();

	//Indicates current method user is on
	c.setFont (method);
	c.drawString ("PauseProgram", 400, 480);

	//Pause Statement
	c.setFont (text);
	c.drawString ("PROGRAM PAUSED", 225, 180);

	//JOptionPane - Needed so that the program allows user to stop and view output
	JOptionPane.showMessageDialog (null, "Click OK to ADVANCE.");

	//If structure waits for user to confirm resume
	if (pIntro == true)
	{
	    pIntro = false;    //Ensures that user returns back to intro method
	    intro ();
	}
	else if (pAskData == true)
	{
	    pAskData = false;  //Ensures that user returns back to askData method
	    askData ();
	}
	else if (pDisplay == true)
	{
	    pDisplay = false;  //Ensures that user returns back to display method
	    display ();

	}
    }



    //Goodbye Method - Allows user to exit program
    public void goodbye ()
    {
	//Default Program Title and Background
	title ();

	//General Text - Indicates method which user is currently on
	c.setFont (method);
	c.drawString ("Goodbye", 450, 480);

	//General Text - Credits and Goodbye Statements
	c.setFont (text);
	c.drawString ("Thank you for using my program!", 140, 180);
	c.drawString ("Created by: Justin Chhay", 190, 225);
	c.drawString ("Teacher: Mr.Afsari-Nejad", 190, 250);
	c.drawString ("Due Date: 12.11.2019", 190, 275);
	c.drawString ("Course Code: ICS3U", 190, 300);

	//Graphics - Face Smiling
	c.drawOval (282, 350, 75, 75);
	c.drawOval (297, 370, 15, 15);
	c.drawOval (327, 370, 15, 15);
	c.drawArc (308, 400, 20, 10, 180, 180);

	//Needed so that the program allows user to stop and view output
	JOptionPane.showMessageDialog (null, "Click OK to EXIT.");
	System.exit (0);

    }


    //Class Constructor
    public JustinChhay_PhysicsFormulaSolver ()
    {
	//Window Title
	c = new Console ("Acceleration Formula Variable Solver");
    }


    //Main Method - Executes defined methods
    public static void main (String[] args)
    {
	//Creates Object of the Class JustinChhay_PhysicsFormulaSolver
	JustinChhay_PhysicsFormulaSolver n;
	n = new JustinChhay_PhysicsFormulaSolver ();

	//Starts program w/ intro method
	n.intro ();
    }
} // JustinChhay_PhysicsFormulaSolver class


