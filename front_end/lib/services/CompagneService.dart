import 'dart:convert';
import 'package:front_end/models/CompagneFonds.dart';
import 'package:http/http.dart' as http;
const String baseUrl = 'http://localhost:6060/api/compagne';
class CompagneService{
var client=http.Client();

//GET
 Future<List<CompagneFonds>> get(String api) async {
   var url = Uri.parse(baseUrl + api);
   var response = await http.get(url);
   if (response.statusCode == 200) {
     List<dynamic> compagnesJson= json.decode(response.body);
     return compagnesJson.map((json) => CompagneFonds.fromJson(json)).toList();
   } else {
     throw Exception('Failed to fetch data from the API');
   }
 }
  //POST
/*Future<dynamic> post(String api, Map<String, dynamic> body) async {
    var url = Uri.parse(baseUrl + api);
    var response = await http.post(
      url,
      headers: {'Content-Type': 'application/json'},
      body: json.encode(body),
    );
    if (response.statusCode == 200) {
      return json.decode(response.body);
    } else {
      throw Exception('Failed to post data to the API');
    }
  }*/
}




