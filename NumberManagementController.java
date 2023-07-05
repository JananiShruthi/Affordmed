@RestController
public class NumberManagementController {
    
    @GetMapping("/numbers")
    public ResponseEntity<List<String>> getNumbers(@RequestParam("http://104.211.219.98/numbers/primes") List<String> urls) {
        List<String> numbers = new ArrayList<>();
        
        // Process each URL and retrieve the numbers
        
        // Example code to make HTTP requests using Apache HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();
        for (String url : urls) {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            
            try {
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                String responseBody = response.body();
                
                // Extract the numbers from the response body and add them to the list
                // Example: numbers.add(extractNumber(responseBody));
                
            } catch (IOException | InterruptedException e) {
                // Handle any errors that occur during the HTTP request
                e.printStackTrace();
            }
        }
        
        return ResponseEntity.ok(numbers);
    }
}