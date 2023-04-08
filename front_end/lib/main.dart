import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:front_end/screens/home.dart';
void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'MADon',
      routes: {
        '/': (context) => const Home(),
      },
    );
  }
}