# neo4j-relationships
SpringBoot app to test relationships

### Setup
1. Clone repository 
2. Set neo4j host credentials in `src/main/resources/application.yml`
3. Start the app using `./gradlew bootRun`
4. The app should be available on `http://localhost:8080`

### Initial setup
The `count` attribute is enabled in the `RelationshipEntity` and demonstrates the duplicating of relationships. 

### Test Urls
1. https://localhost:8080/create - This will create nodes A and B
2. https://localhost:8080/relate - This will create a relationship between nodes A and B (if you call this multiple times you will see the relationship is duplicated
3. https://localhost:8080/transactional - This will created nodes C and D and two relationships between the same node within one transaction. The relationships are duplicated.

### Comment count attribute
If you comment the `count` attribute in `RelationshipEntity` (+ getters/setters/references), delete existing nodes and rerun the URLs above you will notice the relationship is not duplicated. 
