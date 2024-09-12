package petstoretests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MsPetTests extends BaseTest {
    String endPoint = "pet";
    String findByStatus = "/findByStatus?status=";

    enum Status {
        available,
        pending,
        sold
    }

    @DataProvider(name = "status")
    public Object[][] status (){
        return new Object[][] {
                {Status.available},
                {Status.sold},
                {Status.pending}
        };
    }



    @Test(dataProvider = "status", description = "получение списка животных по статусу", priority = 1)
    public void validateSuccessResponseTest(Status state) {
        int collectionSize = sendGetRequest(endPoint + findByStatus + state, 200)
                .extract().body().jsonPath().getList(".[]").size();
        System.out.println(collectionSize);

        //Assert.assertTrue(emptyCollection);







        /*
        for (String operator : country.getPhoneOperators()) {
            sendGetRequest(country.getCountryName(), operator, 200)
                    .body(matchesJsonSchemaInClasspath(JSON_RESPONSE_SCHEMA));
        }

         */
    }
}

