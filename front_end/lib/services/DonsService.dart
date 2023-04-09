import 'dart:convert';
import 'package:front_end/models/CompagneFonds.dart';
import 'package:http/http.dart' as http;

import '../models/Dons.dart';
const String baseUrl = 'http://localhost:6060/api/dons';
class DonsService{
var client=http.Client();
//GET
  Future<List<Dons>> get(String api) async {
    var url = Uri.parse(baseUrl + api);
    var response = await http.get(url);
    if (response.statusCode == 200) {
      List<dynamic> donsJson= json.decode(response.body);
      return donsJson.map((json) => Dons.fromJson(json)).toList();
    } else {
      throw Exception('Failed to fetch data from the API');
    }
  }
  //POST
  Future<void> post(Dons don) async {
    var url = Uri.parse(baseUrl);
    var headers = {'Content-Type': 'application/json'};
    var jsonDon = jsonEncode(don.toJson()); // use the toJson() method to encode the object
    var response = await http.post(url, headers: headers, body: jsonDon);
    if (response.statusCode == 201) {
      print('Donation added successfully');
    } else {
      throw Exception('Failed to add donation to the API');
    }
  }

}