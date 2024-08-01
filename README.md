## Project Scope

### Overview
This platform enables organizations to keep track of their acquired vehicles. The primary functionalities include entering vehicle details, viewing vehicle history, and booking vehicles for specific tasks.

### Key Features

#### Vehicle Management
- Organizations can enter and maintain details of their vehicles.

#### Public Access
- General public or other organizations can view vehicle history.

#### Booking System
- Users can apply to book vehicles for their tasks.
- Booking requests trigger a state-flow action for document verification by the owning organization.
- Upon successful verification, the vehicle is allotted to the booker.
- The vehicle can be picked up at any time within the allotted period.
- After the allotted time finishes, the organization and the booker engage in a state-flow action to provide feedback on the service.
  - The expected outcome is that the booker returns the vehicle in its original condition.
  - If both parties fail to reach an agreement, this platform will only keep track of the exchanged documents.
  - Fines or any other judiciary matters will be managed outside of this platform.

### Future Direction
- **Online Payment Integration**: 
  - Plans to incorporate online payment functionalities for a seamless booking experience.
