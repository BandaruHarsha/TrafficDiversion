
int upirPin = 2;
int ulaststate = HIGH;
int dpirPin = 3;
int count = 0;
int dlaststate = HIGH;

void setup()
{
Serial.begin(9600);
pinMode(upirPin, INPUT);
pinMode(dpirPin, INPUT);
}

void loop()
{
  int ustate = digitalRead(upirPin);
   int dstate = digitalRead(dpirPin);
  if (ulaststate == LOW && ustate == HIGH) // only count on a LOW-> HIGH transition
  {
     count++;
     Serial.println(count);
  }
  ulaststate = ustate;  // remember last state
 if (dlaststate == LOW && dstate == HIGH && count > 0) // only count on a LOW-> HIGH transition
  {
     count--;
     Serial.println(count);
  }
  dlaststate = dstate; 
}
