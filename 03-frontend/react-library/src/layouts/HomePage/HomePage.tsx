
import { Carousal } from './components/Carousal';
import { ExploreTopBooks } from './components/ExploreTopBooks';
import { Heros } from './components/Heros';
import { LibraryServices } from './components/LibraryServices';
import { Footer } from '..//NavbarAndFooter/Footer';
import { Navbar } from '../NavbarAndFooter/Navbar';

export const HomePage = () => {
    return (
        <>
            <ExploreTopBooks />
            <Carousal />
            <Heros />
            <LibraryServices />
        </>
    )
}