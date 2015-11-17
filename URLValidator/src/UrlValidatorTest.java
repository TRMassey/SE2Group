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
	 
     // Scheme
     System.out.println(urlVal.isValid("http://www.google.com"));
     System.out.println(urlVal.isValid("http://www.google.com"));
	   System.out.println(urlVal.isValid("h3tp://www.google.com"));
     System.out.println(urlVal.isValid("://www.google.com"));
     System.out.println(urlVal.isValid("www.google.com"));

     //authority
     System.out.println(urlVal.isValid("http://www.google.com"));
     System.out.println(urlVal.isValid("http://www.google~.com"));
     System.out.println(urlVal.isValid("http://www.google"));
 

     //port
     System.out.println(urlVal.isValid("http://www.google.com:80"));
     System.out.println(urlVal.isValid("http://www.google.com:"));

     //path
      System.out.println(urlVal.isValid("http://www.google.com/test1"));
      System.out.println(urlVal.isValid("http://www.google.com/"));
      System.out.println(urlVal.isValid("http://www.google.comtest1"));
      System.out.println(urlVal.isValid("http://www.google.com//test1"));

      //option
      System.out.println(urlVal.isValid("http://www.google.com/test1/test1"));
      System.out.println(urlVal.isValid("http://www.google.com/test1/"));
      System.out.println(urlVal.isValid("http://www.google.com/test1test1"));
      System.out.println(urlVal.isValid("http://www.google.com/test1//test1"));

      //queries
      System.out.println(urlVal.isValid("http://www.google.com?action=view"));
      System.out.println(urlVal.isValid("http://www.google.com?action="));
      System.out.println(urlVal.isValid("http://www.google.comaction=view"));
      System.out.println(urlVal.isValid("http://www.google.com??action=view"));
   }
   
   
   // scheme partition
   public void testYourFirstPartition()
   {
	   System.out.print("\nTesting Schemes:\n");

     String[] ourSchemes = {"http://", "h3tp://", "://"}
     UrlValidator schemeVal = new UrlValidator(ourSchemes, 0);
     for(int i = 0; i < ourSchemes.length; i++){
        String curScheme = ourSchemes[i];
        System.out.print("\nTesting " + curScheme);
        boolean valid = isValidScheme(curScheme);
        if(valid == false){
          System.out.print("\nFAILED, invalid scheme\n");
        }
     }

   }
   
   // authority partition
   public void testYourSecondPartition(){
	   System.out.print("\nTesting Authority:\n");

     String[] ourAuthority = {"www.google.com", "www.google~.com", "www.google"}
     UrlValidator authVal = new UrlValidator(ourAuthority, 0);
     for(int i = 0; i < ourAuthority.length; i++){
        String curAuth = ourAuth[i];
        System.out.print("\nTesting " + curAuth);
        boolean valid = isValidAuthority(curAuth);
        if(valid == false){
          System.out.print("\nFAILED, invalid authority\n");
        }
     } 
   }
   
    // port partition
   public void testYourThirdPartition(){
     System.out.print("\nTesting Port:\n");

     String[] ourPort = {":80", ":"}
     UrlValidator portVal = new UrlValidator(ourPort, 0);
     for(int i = 0; i < ourPort.length; i++){
        String curPort = ourPort[i];
        System.out.print("\nTesting " + curPort);
        boolean valid = isValidPort(curPort);
        if(valid == false){
          System.out.print("\nFAILED, invalid port\n");
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
