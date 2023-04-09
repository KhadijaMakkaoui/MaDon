import 'package:flutter/material.dart';
import 'package:front_end/constants/colors.dart';
import 'package:front_end/screens/payment.dart';
import 'package:front_end/services/CompagneService.dart';

import '../models/CompagneFonds.dart';

class Details extends StatefulWidget {
  final int campaignId;
  const Details({Key? key, required this.campaignId}) : super(key: key);

  @override
  State<Details> createState() => _DetailsState();
}

class _DetailsState extends State<Details> {
  late Future<CompagneFonds> compagneFonds=CompagneService().fetchCampaignDetailsById(widget.campaignId) ;
  String _title='' ;
  String _description = '';
  String _imagePath = '';
  double _amount = 0.0;
  double _collected=0.0;
  String _associationTitle = '';
  String _associationDescription = '';

  @override
  void initState() {
    super.initState();
    // TODO: Call an API to fetch campaign details based on the campaign ID

  }



  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Container(
          margin: EdgeInsets.only(top: 10),
          padding: EdgeInsets.symmetric(horizontal: 20),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
            Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              IconButton(
                  onPressed: () {
                    Navigator.pop(context);
                  },
                  icon: Icon(
                    Icons.arrow_back_ios,
                    color: Colors.grey,
                    size: 30,
                  )),
              Text(
                'Details',
                style: TextStyle(
                  color: Colors.grey,
                  fontSize: 20,
                ),
              ),
              IconButton(
                  onPressed: () {},
                  icon: Icon(
                    Icons.notifications_none_outlined,
                    color: Colors.grey,
                    size: 30,
                  )),
            ],
          ),
          SizedBox(
            height: 10,
          ),
              FutureBuilder<CompagneFonds>(
                  future: compagneFonds,
                  builder: (context, snapshot) {
                    if(snapshot.hasData){
                      _title = snapshot.data!.titre;
                      _description = snapshot.data!.description;
                      _imagePath = snapshot.data!.imagePath;
                      _amount=snapshot.data!.montantObjectif;
                      _collected=snapshot.data!.montantActuel;
                      /*_associationTitle = snapshot.data!.association!.titre;
                        _associationDescription = snapshot.data!.association!.description;*/
                    }
              return Column(
                children: [

                       Container(
                        margin: EdgeInsets.all(16.0),
                        child: ClipRRect(
                          borderRadius: BorderRadius.circular(8.0),
                          child: Image.asset(
                            _imagePath,
                            width: double.infinity,
                            height: 200.0,
                            fit: BoxFit.cover,
                          ),
                        ),
                      ),

                  Padding(
                    padding: EdgeInsets.all(16.0),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          _title,
                          style: TextStyle(fontSize: 24.0, fontWeight: FontWeight.bold),
                        ),
                        SizedBox(height: 16.0),
                        LinearProgressIndicator(
                          value: 40/100,
                        ),
                        SizedBox(height: 8.0),
                        Text(
                          'Goal: $_amount DH',
                          style: TextStyle(fontSize: 18.0),
                        ),
                        SizedBox(height: 8.0),
                        Text(
                          'Amount Collected:$_collected DH',
                          style: TextStyle(fontSize: 18.0),
                        ),
                        SizedBox(height: 16.0),
                        Text(
                          _description,
                          style: TextStyle(fontSize: 18.0),
                        ),
                      ],
                    ),
                  ),
                ],
              );
            }
          ),
          Column(
            children: [
            Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text(
                'Association',
                style: TextStyle(
                  color: Colors.grey,
                  fontSize: 20,
                ),
              ),
            ],
          ),
          SizedBox(
            height: 20,
          ),
          Row(
              children: [
          CircleAvatar(
          radius: 50,
          backgroundImage: AssetImage('assets/iftar.jpg'),
                                ),
                                SizedBox(
                                  width: 20,
                                ),
                                Column(
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  children: [
                                    Text(
                                      'title',
                                      style: TextStyle(
                                        color: Colors.grey,
                                        fontSize: 20,
                                      ),
                                    ),
                                    SizedBox(
                                      height: 10,
                                    ),
                                    Text(
                                      'description',
                                      style: TextStyle(
                                        color: Colors.grey,
                                        fontSize: 20,
                                      ),
                                    ),
                                  ],
                                ),
                             ],
                           ),


                        ],
                      ),
                      SizedBox(
                        height: 20,
                      ),
                      Padding(
                        padding: const EdgeInsets.symmetric(horizontal: 0.0, vertical: 10.0),
                        child: ElevatedButton(
                          onPressed: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute(builder: (context) => Payment()),
                            );
                          },
                          style: ElevatedButton.styleFrom(
                            foregroundColor: Colors.white,
                            backgroundColor: kPrimaryColor,
                            shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(10.0),
                            ),
                          ),
                          child: Row(
                            mainAxisAlignment: MainAxisAlignment.center,
                            children: [
                              Text(
                                'Donate Now',
                                style: TextStyle(fontSize: 18),
                              ),
                            ],
                          ),
                        ),
                      ),

                    ])
            )
        )
    );
  }
}
