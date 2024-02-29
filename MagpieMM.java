/**
 * A program to carry on conversations with a human user.
 * This version:
 * <ul><li>
 *    Uses advanced search for keywords
 * </li></ul>
 *
 * @author Marie Muya
 * @version June 2023
 */
public class MagpieMM
{
        /**
         * Get a default greeting
         *
         * @return a greeting
         */
        public String getGreeting()
        {
                return "Hello, let's talk.";
        }


        /**
         * Gives a response to a user statement
         *
         * @param statement
         *            the user statement
         * @return a response based on the rules given
         */
        public String getResponse(String statement)
        {
                String response = "";
        statement.trim();
        if (statement.indexOf("no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0)
        {
                response = "Tell me more about your family.";
        }
      else if (statement.indexOf("cat") >= 0
                                || statement.indexOf("dog") >= 0)
                {
                        response = "Tell me more about your pets.";
                }
      else if (statement.indexOf("Windle") >= 0
               || statement.indexOf("Lochamy") >= 0)
                {
                        response = "He sounds like a good teacher.";
                }
      else if (statement.indexOf("Norris") >= 0
            || statement.indexOf("Zarzour") >= 0
                                || statement.indexOf("Ort") >= 0)
                {
                        response = "She sounds like a good teacher.";
                }
      else if (statement.length() == 0)
                {
      response = "This silence is awkward.";
                }
      else if (statement.indexOf("brother") >= 0
                                || statement.indexOf("sister") >= 0)
                {
                    response = "Are they older or younger than you?";
                }
      else if (statement.indexOf("school") >= 0)
                {
                        response = "What is your role at school?";
                }
        else if (statement.indexOf("I want") >= 0)
                {
                        response = "Why do you want it?";
                }
        else if (statement.indexOf("I like") >= 0)
                {
                        response = "Why do you like it?";
                }
                else
                {
                        response = getRandomResponse();
                }
                return response;
        }




        /**
         * Search for one word in phrase.  The search is not case sensitive.
         * This method will check that the given goal is not a substring of a longer string
         * (so, for example, "I know" does not contain "no").
         * @param statement the string to search
         * @param goal the string to search for
         * @param startPos the character of the string to begin the search at
         * @return the index of the first occurrence of goal in statement or -1 if it's not found
         */
    private int findKeyword(String statement, String goal, int startPos)
   {
      String phrase = statement.trim().toLowerCase();
      goal = goal.toLowerCase();
      //  The only change to incorporate the startPos is in the line below
      int psn = phrase.indexOf(goal, startPos);


      //  Refinement--make sure the goal isn't part of a word
      while (psn >= 0)
      {
         //  Find the string of length 1 before and after the word
         String before = " ";
         String after = " ";
         if (psn > 0)
         {
            before = phrase.substring (psn - 1, psn);
         }
         if (psn + goal.length() < phrase.length())
         {
            after = phrase.substring(psn + goal.length(), psn + goal.length() + 1);
         }
//determine the values of psn, before, and after at this point in the method


         if ((before.compareTo ("a") < 0  || before.compareTo("z") > 0)  //  before is not a letter
           &&(after.compareTo ("a") < 0   || after.compareTo("z") > 0))
         {
            return psn;
         }


         psn = phrase.indexOf(goal.toLowerCase(), psn + 1);


      }


      return -1;
   }




        /**
         * Search for one word in phrase. The search is not case
         * sensitive. This method will check that the given goal
         * is not a substring of a longer string (so, for
         * example, "I know" does not contain "no"). The search
         * begins at the beginning of the string.
         *
         * @param statement
         *            the string to search
         * @param goal
         *            the string to search for
         * @return the index of the first occurrence of goal in
         *         statement or -1 if it's not found
         */
        private int findKeyword(String statement, String goal)
        {
                return findKeyword(statement, goal, 0);
        }


        /**
         * Pick a default response to use if nothing else fits.
         *
         * @return a non-committal string
         */
        private String getRandomResponse()
        {
                final int NUMBER_OF_RESPONSES = 6;
                double r = Math.random();
                int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
                String response = "";


                if (whichResponse == 0)
                {
                        response = "Interesting, tell me more.";
                }
                else if (whichResponse == 1)
                {
                        response = "Hmmm.";
                }
                else if (whichResponse == 2)
                {
                        response = "Do you really think so?";
                }
                else if (whichResponse == 3)
                {
                        response = "You don't say.";
                }
      else if (whichResponse == 4)
                {
                        response = "Could you repeat that?.";
                }
      else if (whichResponse == 5)
           {
                        response = "When was this?";
                }


                return response;
   }
}