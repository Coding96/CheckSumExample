import java.io.InputStreamReader;
import java.io.IOException;

//generates a checksum for a given textfile
//this can be used to determine whether the file was damaged in transit
//or has been edited

public class CheckSum
{
  public static void main(String args[])
  {
    InputStreamReader input = new InputStreamReader(System.in);
    
    //init checksum
    //declare currentbyte
    int checkSum = 0;
    int currentbyte;
    
    try
    {
      //until currentbyte is the end of the file then keep reading
      while((currentbyte = input.read()) != -1) //Every byte form input
      {
	//if its even divide by 2
	if (checkSum % 2 == 0)
	{
	  checkSum /= 2;
	}
	else
	{
	  //else perform the rotate right
	  checkSum /= 2;
	  checkSum += 32768;
	}
	
	//increment the checksum
	checkSum += currentbyte;
	
	//if checksum is greater than our limit
	//then roll back over to 0 and start 
	//again
	if (checkSum >= 65536)
	{
	  checkSum -= 65536;
	}
      }
    }
    catch(Exception IOException)
    {
    //catch an IOException and print out what happened
      System.out.println("input failure");
    }
    finally
    {
      //finally we output our results
      System.out.println("The checksum is: " + checkSum);
    }
   
  }
}
