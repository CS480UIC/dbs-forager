
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
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) <br />
2. [food_type](#food_type) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
3. [calorie_tracker](#calorie_tracker)
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (0) <br />
4. [donor_id](#donor_id) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />

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
- Relationship Minima : (1) <br />
2. [pick_up_location](#pick_up_location) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
3. [drop_location](#drop_location) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
4. [transporter_id](#transporter_id) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
5. [food_id](#food_id) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
6. [pick_up_time](#pick_up_time) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) <br />
7. [drop_time](#drop_time) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) <br />
8. [receiver_id](#receiver_id) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
9. [donor_id](#donor_id) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />

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
- Attribute Minima : (1) <br />
2. [username](#username) - <br />
- Attribute Maxima : (1-1) <br />
- Attribute Minima : (1) <br />
3. [password](#password)
- Attribute Maxima : (1-1) <br />
- Attribute Minima : (1) <br />
4. [name_of_organisation](#name_of_organisation) - <br />
- Attribute Maxima : (M-M) <br />
- Attribute Minima : (0) <br />
5. [org_id](#org_id) - <br />
- Attribute Maxima : (1-1) <br />
- Attribute Minima : (0) <br />
6. [first_name](#first_name) - <br />
- Attribute Maxima : (1-M) <br />
- Attribute Minima : (1) <br />
7. [last_name](#last_name) - <br />
- Attribute Maxima : (1-M) <br />
- Attribute Minima : (1) <br />
8. [email_id](#email_id) - <br />
- Attribute Maxima : (1-1) <br />
- Attribute Minima : (1) <br />
9. [contact_number](#contact_number) - <br />
- Attribute Maxima : (M-1) <br />
- Attribute Minima : (1) <br />
10. [address](#address) - <br />
- Attribute Maxima : (M-1) <br />
- Attribute Minima : (1) <br />

## Entity Name : nutrition
Synonyms : dietetics, nourishment <br />
Description : Nutrition information for common foods that are donated and received

## Relationship
1. [Food-Contains-Nutrition](#Food-Contains-Nutrition) - <br />
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) <br />


## Attributes
1. [food_id](#food_id) - <br />
- Attribute Maxima : (1-1) <br />
- Attribute Minima : (1) <br />
2. [nutrition_value_in_calories](#nutrition_value_in_calories) - <br />
- Attribute Maxima : (M-1) <br />
- Attribute Minima : (1) <br />
3. [health_meter](#health_meter)
- Attribute Maxima : (M-1) <br />
- Attribute Minima : (1) <br />


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
- Attribute Minima : (1) <br />
2. [volunteer_name](#volunteer_name) - <br />
- Attribute Maxima : (1-1) <br />
- Attribute Minima : (1) <br />
3. [preferred_location](#preferred_location)
- Attribute Maxima : (M-M) <br />
- Attribute Minima : (1) <br />
4. [location_radius](#location_radius)
- Attribute Maxima : (M-M) <br />
- Attribute Minima : (1) <br />
5.[availability_dates](#availability_dates)
- Attribute Maxima : (M-M) <br />
- Attribute Minima : (1) <br />


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
- Relationship Minima : (1) <br />
2. [donor_type](#donor_type) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
3. [no_of_times_donated](#no_of_times_donated)
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
4. [user_id](#donor_id) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
5. [avg_rating_received](#avg_rating_received) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (0) <br />

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
- Relationship Minima : (1) <br />
2. [user_id](#user_id) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
3. [avg_rating_given](#avg_rating_given) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (0) <br />




## Entity Name : intractions
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
- Relationship Minima : (1) <br />
2. [user_id](#user_id) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
3. [avg_rating_given](#avg_rating_given) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (0) <br />

