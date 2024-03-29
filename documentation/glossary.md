
## Entity Name : food
Synonyms : Meal, Grub <br />
Description : Food is requested by a user who is a receiver and is donated by a donor.

## Relationship

1. [Food-Contains-Nutrition](#Food-Contains-Nutrition) - <br />
- Relationship Maxima : (M-1) <br />
- Relationship Minima : (1-1) <br />
2. [Order-Contains-Food](#[Order-Contains-Food) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (0-1) <br />
3. [Donor-Donates-Food](#Donor-Donates-Food) - <br />
- Relationship Maxima : (M-1) <br />
- Relationship Minima : (1-1) <br />

## Attributes
1. [food_id](#food_id) - <br />
- Relationship Maxima : (1-1)  <br />
- Relationship Minima : (1) NOT NULL <br />
2. [food_type](#food_type) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1)  NOT NULL<br />
3. [calorie_tracker](#calorie_tracker)
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (0) <br />
4. [donor_id](#donor_id) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1)  NOT NULL<br />

## Entity Name : order
Synonyms : Order, Booking <br />
Description : An Order is delivered to the receiver by a volunteer and the order placed by the receiver is fulfilled by a donor.

## Relationship

1. [Receiver-Receives-Order](#Food-Contains-Nutrition) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1-1) <br />
2. [Donor-Donates-Order](#[Order-Contains-Food) - <br />
- Relationship Maxima : (M-M) <br />
- Relationship Minima : (1-0) <br />
3. [Order-Contains-Food](#[Order-Contains-Food) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (0-1) <br />

## Attributes
1. [order_id](#order_id) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) NOT NULL<br />
2. [pick_up_location](#pick_up_location) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) NOT NULL<br />
3. [drop_location](#drop_location) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) NOT NULL<br />
4. [transporter_id](#transporter_id) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) NOT NULL<br />
5. [food_id](#food_id) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) NOT NULL<br />
6. [pick_up_time](#pick_up_time) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) NOT NULL<br />
7. [drop_time](#drop_time) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) NOT NULL<br />
8. [receiver_id](#receiver_id) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) NOT NULL<br />
9. [donor_id](#donor_id) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) NOT NULL<br />

## Entity Name : user
Synonyms : Client, Subscriber <br />
Description : Contains details of the user signing into the website irrespective of them being a donor,receiver or volunteer

## Relationship
1. [Volunteer-RegisteredAs-User](#Volunteer-RegisteredAs-User) - <br />
- Relationship Maxima : (M-1) <br />
- Relationship Minima : (1) <br />
2. [Receiver-RegisteredAs-User](#[Receiver-RegisteredAs-User) - <br />
- Relationship Maxima : (M-1) <br />
- Relationship Minima : (1) <br />
3. [Donor-RegisteredAs-User](#Donor-RegisteredAs-User) - <br />
- Relationship Maxima : (M-1) <br />
- Relationship Minima : (1) <br />
4. [User-Sends-Message](#User-Sends-Message) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (0) <br />
5. [User-Receives-Message](#User-Receives-Message) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (0) <br />
6. [User-BelongsTo-Org](#User-BelongsTo-Org) - <br />
- Relationship Maxima : (M-M) <br />
- Relationship Minima : (0) <br />


## Attributes
1. [user_id](#user_id) - <br />
- Attribute Maxima : (1-1) <br />
- Attribute Minima : (1) Not Null <br />
2. [username](#username) - <br />
- Attribute Maxima : (1-1) <br />
- Attribute Minima : (1) Not Null <br />
3. [password](#password)
- Attribute Maxima : (1-1) <br />
- Attribute Minima : (1) Not Null <br />
4. [name_of_organisation](#name_of_organisation) - <br />
- Attribute Maxima : (M-M) <br />
- Attribute Minima : (0) Null<br />
5. [org_id](#org_id) - <br />
- Attribute Maxima : (1-1) <br />
- Attribute Minima : (0) Null <br />
6. [first_name](#first_name) - <br />
- Attribute Maxima : (1-M) <br />
- Attribute Minima : (1) Not Null<br />
7. [last_name](#last_name) - <br />
- Attribute Maxima : (1-M) <br />
- Attribute Minima : (1) Not Null<br />
8. [email_id](#email_id) - <br />
- Attribute Maxima : (1-1) <br />
- Attribute Minima : (1) Not Null <br />
9. [contact_number](#contact_number) - <br />
- Attribute Maxima : (M-1) <br />
- Attribute Minima : (1) Not Null<br />
10. [address](#address) - <br />
- Attribute Maxima : (M-1) <br />
- Attribute Minima : (1) Not Null<br />


## Entity Name : volunteer
Synonyms : participant, service men <br />
Description : Users can register as volunteers to help deliver the orders from the donor to receiver

## Relationship
1. [Volunteer-RegisteredAs-User](#Volunteer-RegisteredAs-User) - <br />
- Relationship Maxima : (M-1) <br />
- Relationship Minima : (1) <br />


## Attributes
1. [volunteer_id](#volunteer_id) - <br />
- Attribute Maxima : (1-1) <br />
- Attribute Minima : (1)Not Null <br />
2. [volunteer_name](#volunteer_name) - <br />
- Attribute Maxima : (1-1) <br />
- Attribute Minima : (1) Not Null<br />
3. [preferred_location](#preferred_location)
- Attribute Maxima : (M-M) <br />
- Attribute Minima : (1) Not Null<br />
4. [location_radius](#location_radius)
- Attribute Maxima : (M-M) <br />
- Attribute Minima : (1) Not Null<br />
5.[availability_dates](#availability_dates)
- Attribute Maxima : (M-M) <br />
- Attribute Minima : (1) Not Null<br />


## Entity Name : donor
Synonyms : Giver, Contributer <br />
Description : Donor is a user who donates food to a receiver.

## Relationship

1. [Donor-RegisteredAs-User](#Donor-RegisteredAs-User) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1-1) <br />
2. [Donor-Donates-Food](#Donor-Donates-Food) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1-1) <br />
3. [Donor-Donates-Order](#Donor-Donates-Order) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1-1) <br />

## Attributes
1. [donor_id](#donor_id) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) Not Null<br />
2. [donor_type](#donor_type) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) Not Null<br />
3. [no_of_times_donated](#no_of_times_donated)
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (0) Null<br />
4. [user_id](#donor_id) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) Not Null<br />
5. [avg_rating_received](#avg_rating_received) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (0) Null<br />

## Entity Name : receiver
Synonyms : Receipient, Beneficiary <br />
Description : Receiver is a user who receives food from the donor.

## Relationship

1. [Receiver-RegisteredAs-User](#Receiver-RegisteredAs-User) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1-1) <br />
2. [Receiver-Receives-Order](#Receiver-Receives-Order) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1-1) <br />

## Attributes
1. [receiver_id](#receiver_id) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) Not Null<br />
2. [user_id](#user_id) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) Not Null<br />
3. [avg_rating_given](#avg_rating_given) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (0) Null<br />
4. [receiver_type](#receiver_type) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) Not Null<br />




## Entity Name : interaction
Synonyms : interactivity, exchange <br />
Description : intraction mainly stores pointers to messages from users.

## Relationship

1. [User-Sends-Message](#User-Sends-Message) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1-1) <br />
2. [User-Receives-Message](#User-Receives-Message) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1-1) <br />
3. [Messages-Stores-MessageContent](#Messages-Stores-MessageContent) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1-0) <br />

## Attributes
1. [interaction_id](#interaction_id) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) Not Null <br />
2. [from](#from) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) Not Null <br />
3. [to](#to) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) Not Null <br />
4. [message_id](#message_id) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) Not Null <br />
5. [reply_of](#reply_of) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (0) <br />
6. [timestamp](#timestamp) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) Not Null <br />


## Entity Name : messages
Synonyms : communication, posting <br />
Description : messages holds message content from donor/receiver.

## Relationship

1. [Messages-Stores-MessageContent](#Messages-Stores-MessageContent) - <br />
- Relationship Maxima : (M-1) <br />
- Relationship Minima : (1-1) <br />


## Attributes
1. [messages_id](#messages_id) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) Not Null <br />
2. [message_content](#message_content ) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) Not Null <br />


## Entity Name : restaurant
Synonyms : organization <br />
Description : donor could optionally belong to an organization/restaurant.

## Relationship

1. [User-BelongsTo-Org](#User-BelongsTo-Org) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1-1) <br />


## Attributes
1. [restaurant_id](#restaurant_id) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) Not Null <br />
2. [safety_rating](#safety_rating) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (0) <br />
3. [food_type](#food_type) - <br />
- Relationship Maxima : (M-1) <br />
- Relationship Minima : (1) Not Null <br />
4. [address](#address) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) Not Null <br />



## Dependent entities:
1. Donor
2. Receiver
3. Volunteer
4. Food
5. Order

## Independent entities: 
1. User

## Dependency Relationships:
1. Donor dependsOn User
2. Receiver dependsOn User
3. Volunteer dependsOn User
4. Food dependsOn Donor
5. Order dependsOn Food


## Cascade and restrict actions for dependency relationships:
1. Donor dependsOn User: on delete cascade, on update cascade
2. Receiver dependsOn User: on delete cascade, on update cascade
3. Volunteer dependsOn User: on delete cascade, on update cascade
4. Food dependsOn Donor: on delete set null, on update cascade
5. Order dependsOn Food: on delete cascade, on update cascade


## Cascade and restrict rules on foreign keys that implement dependency:
1. Donor foreign key user_id references User (id)
2. Receiver foreign key user_id references User(id)
3. Volunteer foreignn key user_id references User(id)
