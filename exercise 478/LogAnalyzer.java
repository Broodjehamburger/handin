/**
 * Read web server data and analyse
 * hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    public LogAnalyzer(String filename) {
        hourCounts = new int[24];
        reader = new LogfileReader(filename);
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }

    public void printHourlyCountwhile(){
        int index = 0;
        System.out.println("hr: Count");
        while(index < hourCounts.length){
            System.out.println(index + " : " + this.hourCounts[index]);
            index++;
        }
    }

    /**
     * Print all the values in the marks array that are
     * greater than mean.
     * @param marks An array of mark values.
     * @param mean The mean (average) mark.
     */
    public void printGreater(double[] marks, double mean)
    {

        for(int index = 0;  index < marks.length; index++) {
            if(marks[index] > mean) {
                System.out.println(marks[index]);
            }
        }
    }

    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }

    /**
     * Return the number of accesses recorded in the log
     * file.
     */
    public int numberOfAccesses()
    {
        int total = 0;
        // Add the value in each element of hourCounts
        // to total.
        for (int i = 0; i < this.hourCounts.length; i++) {
            total += this.hourCounts[i];
        }
        return total;
    }

    public int busiestHour()
    {
        // Initialize two variables and set them to 0
        int highestValue = 0;
        int highestIndex = 0;

        // Loop over all the array indexes
        for (int i = 0; i < this.hourCounts.length; i++) {
            // If the value of the current index element is bigger than the integer stored in highestValue variable
            if (this.hourCounts[i] > highestValue) {
                // Then overwrite the old value with value of the current index of the loop
                highestValue = this.hourCounts[i]; 
                // Then store the current index (which holds the biggest value) to the highest index array
                highestIndex = i;   
            }
        }

        // Return the highest index
        return highestIndex;
    }

    public int quietestHour()
    {
        int lowestValue = this.hourCounts[0];
        int lowestIndex = 0;

        for (int i = 0; i < this.hourCounts.length; i++) {
            if (this.hourCounts[i] < lowestValue) {
                lowestValue = this.hourCounts[i];
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }

    public int busiestTwoHours()
    {
        int highestTwoHours = 0;
        int highestTwoHoursIndex = 0;

        for (int i = 0; i < this.hourCounts.length; i += 2) {
            int total = (this.hourCounts[i] + this.hourCounts[i + 1]);
            if (total > highestTwoHours) {
                highestTwoHours = total;
                highestTwoHoursIndex = i;
            }
        }
        return highestTwoHoursIndex;
    }
}
