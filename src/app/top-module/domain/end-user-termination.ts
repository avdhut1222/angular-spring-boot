import {EndUserLocation} from "./end-user-location";

export interface EndUserTermination {
  primaryLocation: EndUserLocation;
  secondaryLocation: EndUserLocation;
}
