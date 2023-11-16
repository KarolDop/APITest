package files;

import org.example.Pet;

public class AddPetJson {
    public static String AddPet(Pet pet) {
        String addPetJson = "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"" + pet.getPetCategory() + "\"\n" +
                "  },\n" +
                "  \"name\": \"" + pet.getPetName() + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        return addPetJson;
    }

    public static String price() {
        return "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 900,\n" +
                "    \"website\": \"xxx.com\"\n" +
                "  },\n" +
                "  \"contents\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"red\",\n" +
                "\t  \"price\": 50\n" +
                "    },\n" +
                "\t{\n" +
                "      \"id\": 2,\n" +
                "      \"name\": \"blonde\",\n" +
                "\t  \"price\": 150\n" +
                "    },\n" +
                "\t{\n" +
                "      \"id\": 3,\n" +
                "      \"name\": \"black\",\n" +
                "\t  \"price\": 190\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
}
