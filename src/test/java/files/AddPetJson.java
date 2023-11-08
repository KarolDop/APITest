package files;

import org.example.Pet;

public class AddPetJson
{
    public static String AddPet(Pet pet)
    {
        String addPetJson = "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": " + pet.getPetCategory() + "\n" +
                "  },\n" +
                "  \"name\": " + pet.getPetName() + ",\n" +
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
}
