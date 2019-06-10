import {PsrServiceLocation} from './psr-service-location';
import {TopChildSr} from './top-child-sr';

export interface ServiceLocation {
  psrServiceLocation: PsrServiceLocation;
  asrServiceLocation:  TopChildSr[];
  lsrServiceLocation:  TopChildSr[];
}
