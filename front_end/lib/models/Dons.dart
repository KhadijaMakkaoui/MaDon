import 'package:flutter/material.dart';
class Dons{
  int id;
  String ref;
  double amount;
  DateTime date;

  Dons(this.id, this.ref, this.amount, this.date);

  Dons.fromJson(Map<String, dynamic> json)
      : id = json['id'],
        ref = json['ref'],
        amount = json['amount'],
        date = json['date'];
}