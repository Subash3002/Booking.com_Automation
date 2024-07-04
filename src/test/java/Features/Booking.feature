Feature: Booking Automation
  Scenario: To Book Hotel Rooms
    Given User Launch Chrome browser
    When User opens URL "https://booking.com"
    Then Page Title should be "Booking.com | Official site | The best hotels, flights, car rentals & accommodations"
    When User Types the destination "Tirupati"
    And User selects checkin "6 July 2024" and checkout "8 July 2024" dates
    And User clicks search
    Then Page Title should be "Booking.com: Hotels in Tirupati. Book your hotel now!"
    When User applies filter
    And User clicks first hotel in the displayed list
    Then User navigates to the Hotel page
    When User selects room from the hotel
    And User Reverse the selected room
    Then Page Title should be "Booking.com: Your details"



