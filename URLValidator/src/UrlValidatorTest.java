/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import junit.framework.TestCase;





/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	 
     System.out.println("\nAllowing all schemes: \n");
     // Scheme
     System.out.println("\nShould Validate: \n");
     System.out.println(urlVal.isValid("http://www.google.com"));
     System.out.println(urlVal.isValid("http://www.google.com"));
     System.out.println(urlVal.isValid("www.google.com"));
     System.out.println("\nShould Not Validate: \n");
	   System.out.println(urlVal.isValid("h3tp://www.google.com"));
     System.out.println(urlVal.isValid("://www.google.com"));


     //authority
     System.out.println("\nShould Validate: \n");
     System.out.println(urlVal.isValid("http://www.google.com"));
     System.out.println("\nShould Not Validate: \n");
     System.out.println(urlVal.isValid("http://www.google~.com"));
     System.out.println(urlVal.isValid("http://www.google"));
 

     //port
     System.out.println("\nShould Validate: \n");
     System.out.println(urlVal.isValid("http://www.google.com:80"));
     System.out.println("\nShould Not Validate: \n");
     System.out.println(urlVal.isValid("http://www.google.com:"));

     //path
      System.out.println("\nShould Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com/test1"));
      System.out.println(urlVal.isValid("http://www.google.com/"));
      System.out.println("\nShould Not Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.comtest1"));
      System.out.println(urlVal.isValid("http://www.google.com//test1"));

      //option
      System.out.println("\nShould Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com/test1/test1"));
      System.out.println(urlVal.isValid("http://www.google.com/test1/"));
      System.out.println("\nShould Not Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com/test1test1"));
      System.out.println(urlVal.isValid("http://www.google.com/test1//test1"));

      //queries
      System.out.println("\nShould Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com?action=view"));
      System.out.println("\nShould Not Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com?action="));
      System.out.println(urlVal.isValid("http://www.google.comaction=view"));
      System.out.println(urlVal.isValid("http://www.google.com??action=view"));


     UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.NO_FRAGMENTS);
     System.out.println("\nAllowing No Fragments: \n");
          // Scheme
     System.out.println("\nShould Validate: \n");
     System.out.println(urlVal.isValid("http://www.google.com"));
     System.out.println(urlVal.isValid("http://www.google.com"));
     System.out.println(urlVal.isValid("www.google.com"));
     System.out.println("\nShould Not Validate: \n");
     System.out.println(urlVal.isValid("h3tp://www.google.com"));
     System.out.println(urlVal.isValid("://www.google.com"));


     //authority
     System.out.println("\nShould Validate: \n");
     System.out.println(urlVal.isValid("http://www.google.com"));
     System.out.println("\nShould Not Validate: \n");
     System.out.println(urlVal.isValid("http://www.google~.com"));
     System.out.println(urlVal.isValid("http://www.google"));
 

     //port
     System.out.println("\nShould Validate: \n");
     System.out.println(urlVal.isValid("http://www.google.com:80"));
     System.out.println("\nShould Not Validate: \n");
     System.out.println(urlVal.isValid("http://www.google.com:"));

     //path
      System.out.println("\nShould Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com/test1"));
      System.out.println(urlVal.isValid("http://www.google.com/"));
      System.out.println("\nShould Not Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.comtest1"));
      System.out.println(urlVal.isValid("http://www.google.com//test1"));

      //option
      System.out.println("\nShould Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com/test1/test1"));
      System.out.println(urlVal.isValid("http://www.google.com/test1/"));
      System.out.println("\nShould Not Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com/test1test1"));
      System.out.println(urlVal.isValid("http://www.google.com/test1//test1"));

      //queries
      System.out.println("\nShould Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com?action=view"));
      System.out.println("\nShould Not Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com?action="));
      System.out.println(urlVal.isValid("http://www.google.comaction=view"));
      System.out.println(urlVal.isValid("http://www.google.com??action=view"));

    UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_LOCAL_URLS);
     System.out.println("\nAllowing local urls: \n");
          // Scheme
     System.out.println("\nShould Validate: \n");
     System.out.println(urlVal.isValid("http://www.google.com"));
     System.out.println(urlVal.isValid("http://www.google.com"));
     System.out.println(urlVal.isValid("www.google.com"));
     System.out.println("\nShould Not Validate: \n");
     System.out.println(urlVal.isValid("h3tp://www.google.com"));
     System.out.println(urlVal.isValid("://www.google.com"));


     //authority
     System.out.println("\nShould Validate: \n");
     System.out.println(urlVal.isValid("http://www.google.com"));
     System.out.println("\nShould Not Validate: \n");
     System.out.println(urlVal.isValid("http://www.google~.com"));
     System.out.println(urlVal.isValid("http://www.google"));
 

     //port
     System.out.println("\nShould Validate: \n");
     System.out.println(urlVal.isValid("http://www.google.com:80"));
     System.out.println("\nShould Not Validate: \n");
     System.out.println(urlVal.isValid("http://www.google.com:"));

     //path
      System.out.println("\nShould Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com/test1"));
      System.out.println(urlVal.isValid("http://www.google.com/"));
      System.out.println("\nShould Not Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.comtest1"));
      System.out.println(urlVal.isValid("http://www.google.com//test1"));

      //option
      System.out.println("\nShould Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com/test1/test1"));
      System.out.println(urlVal.isValid("http://www.google.com/test1/"));
      System.out.println("\nShould Not Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com/test1test1"));
      System.out.println(urlVal.isValid("http://www.google.com/test1//test1"));

      //queries
      System.out.println("\nShould Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com?action=view"));
      System.out.println("\nShould Not Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com?action="));
      System.out.println(urlVal.isValid("http://www.google.comaction=view"));
      System.out.println(urlVal.isValid("http://www.google.com??action=view"));

    

     UrlValidator urlVal = new UrlValidator();
     System.out.println("\nDefault: \n");
          // Scheme
     System.out.println("\nShould Validate: \n");
     System.out.println(urlVal.isValid("http://www.google.com"));
     System.out.println(urlVal.isValid("http://www.google.com"));
     System.out.println(urlVal.isValid("www.google.com"));
     System.out.println("\nShould Not Validate: \n");
     System.out.println(urlVal.isValid("h3tp://www.google.com"));
     System.out.println(urlVal.isValid("://www.google.com"));


     //authority
     System.out.println("\nShould Validate: \n");
     System.out.println(urlVal.isValid("http://www.google.com"));
     System.out.println("\nShould Not Validate: \n");
     System.out.println(urlVal.isValid("http://www.google~.com"));
     System.out.println(urlVal.isValid("http://www.google"));
 

     //port
     System.out.println("\nShould Validate: \n");
     System.out.println(urlVal.isValid("http://www.google.com:80"));
     System.out.println("\nShould Not Validate: \n");
     System.out.println(urlVal.isValid("http://www.google.com:"));

     //path
      System.out.println("\nShould Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com/test1"));
      System.out.println(urlVal.isValid("http://www.google.com/"));
      System.out.println("\nShould Not Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.comtest1"));
      System.out.println(urlVal.isValid("http://www.google.com//test1"));

      //option
      System.out.println("\nShould Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com/test1/test1"));
      System.out.println(urlVal.isValid("http://www.google.com/test1/"));
      System.out.println("\nShould Not Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com/test1test1"));
      System.out.println(urlVal.isValid("http://www.google.com/test1//test1"));

      //queries
      System.out.println("\nShould Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com?action=view"));
      System.out.println("\nShould Not Validate: \n");
      System.out.println(urlVal.isValid("http://www.google.com?action="));
      System.out.println(urlVal.isValid("http://www.google.comaction=view"));
      System.out.println(urlVal.isValid("http://www.google.com??action=view"));

   }
   
   
   // scheme partition
   public void testYourFirstPartition()
   {
	   System.out.println("\nTesting Schemes:\n");

     String[] ourSchemes = {"http://", "h3tp://", "://"}
     UrlValidator schemeVal = new UrlValidator(ourSchemes, 0);
     for(int i = 0; i < ourSchemes.length; i++){
        String curScheme = ourSchemes[i];
        System.out.println("\nTesting " + curScheme);
        boolean valid = isValidScheme(curScheme);
        if(valid == false){
          System.out.println("\nFAILED, invalid scheme\n");
        }
     }

   }
   
   // authority partition
   public void testYourSecondPartition(){
	   System.out.println("\nTesting Authority:\n");

     String[] ourAuthority = {"www.google.com", "www.google~.com", "www.google"}
     UrlValidator authVal = new UrlValidator(ourAuthority, 0);
     for(int i = 0; i < ourAuthority.length; i++){
        String curAuth = ourAuth[i];
        System.out.println("\nTesting " + curAuth);
        boolean valid = isValidAuthority(curAuth);
        if(valid == false){
          System.out.println("\nFAILED, invalid authority\n");
        }
     } 
   }
   
    // port partition - Done with the isValidAuthority(String authority) function
   public void testYourThirdPartition(){
     System.out.println("\nTesting Port:\n");

     String[] ourPort = {"www.google.com:80", "www.google.com:"}
     UrlValidator portVal = new UrlValidator(ourPort, 0);
     for(int i = 0; i < ourPort.length; i++){
        String curPort = ourPort[i];
        System.out.println("\nTesting " + curPort);
        boolean valid = isValidAuthority(curPort);
        if(valid == false){
          System.out.println("\nFAILED, invalid port\n");
        }
     } 
   }
   
    // path Partition
   public void testYourFourthPartition(){
     System.out.println("\nTesting Path:\n");

     String[] ourPort = {"/test1", "//test1", "/", "test1"}
     UrlValidator pathVal = new UrlValidator(ourPat, 0);
     for(int i = 0; i < ourPath.length; i++){
        String curPath = ourPath[i];
        System.out.println("\nTesting " + curPath);
        boolean valid = isValidPath(curPath);
        if(valid == false){
          System.out.println("\nFAILED, invalid path\n");
        }
     } 
   }


    // query Partition
   public void testYourFifthPartition(){
     System.out.println("\nTesting Queries:\n");

     String[] ourQueries = {"/test1", "//test1", "/", "test1"}
     UrlValidator pathQuery = new UrlValidator(ourQueries, 0);
     for(int i = 0; i < ourQueries.length; i++){
        String curQuery = ourQueries[i];
        System.out.println("\nTesting " + curQueryPath);
        boolean valid = isValidQuery(curQuery);
        if(valid == false){
          System.out.println("\nFAILED, invalid Query\n");
        }
     } 
   }


   public void testIsValid()
   {

	   for(int i = 0;i<10000;i++)
	   {
		   
	   }
   }
   
   public void testAnyOtherUnitTest()
   {
	   
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   

}
